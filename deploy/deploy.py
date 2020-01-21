import docker
import sys
import docker_api
import time
import os

repository = 'mpassarge/nhl-system'

client = docker.from_env()
api_client = docker.APIClient()

images = client.images.list(name=repository) 

print("Class: " + str(images.__class__))
print("Images: " + str(images))

image = images[0]
tags = image.tags

print("Tags: " + str(tags))

if(len(tags) != 1):
    print("Too manh tags found for image: " + str(image))
    sys.exit(-1)

tag = tags[0].replace(repository + ':', '')
print(tag)

# Validate tag hasn't been deployed to dockerhub already (docker hub rest docker-api???)
api_response = docker_api.is_tag_deployed(repository, tag)
if(api_response.status_code == 200):
    print("Tag is already deployed")
    sys.exit(-1)

# Login to dockerhub
login = client.login(username=os.environ['DOCKER_USERNAME'], password=os.environ['DOCKER_TOKEN'])
print(login)

# Push tag to dockerhub
client.images.push(repository=repository)

time.sleep(1)
api_response = docker_api.is_tag_deployed(repository, tag)
deployed_image_id = api_response.json()['images'][0]['digest']
if(api_response.status_code == 404):
    print("Tag failed to deploy")
    sys.exit(-1)

# Tag image with latest
tagged = image.tag(repository, tag='latest')
if(not tagged):
    #TODO: Delete tagged image from above
    print("Failed to tag image as latest")
    sys.exit(-1)

# Push new tag to dockerhub
client.images.push(repository=repository, tag='latest')

#TODO: Find out how to find the digest of the 'latest' tag to match the newest upload
api_response = docker_api.is_tag_deployed(repository, tag)
deployed_latest_digest = api_response.json()['images'][0]['digest']

if(deployed_image_id != deployed_latest_digest):
    print("Deployed latest does not match tag just deployed")
    sys.exit(-1)