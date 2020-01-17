#!/bin/bash

set -e

IMAGES=$(docker images mpassarge/nhl-system --format {{.Repository}}:{{.Tag}})

#echo $DOCKER_TOKEN | docker login --username $DOCKER_USERNAME --password-stdin

for image in $IMAGES
do
  ID=$(docker images $image --format {{.ID}})
  echo Deploying: $image with Id: $ID
  #docker push $image
done

#docker logout