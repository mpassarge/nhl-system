import requests
import docker

_docker_client = docker.from_env()

def get_images(repository):
    return _docker_client.images.list(repository)

def is_tag_deployed(repository, tag):
    url = "https://hub.docker.com/v2/repositories/{repository}/tags/{tag}"
    url = url.replace('{repository}', repository)
    url = url.replace('{tag}', tag)
    print(url)
    r = requests.get(url)
    return r