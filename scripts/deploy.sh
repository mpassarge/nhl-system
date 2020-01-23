#!/bin/bash

set -e

version=$(mvn help:evaluate -f ../pom.xml -Dexpression=project.version -q -DforceStdout)

echo "Trying to deploy version $version"

./version-validation.sh $version

echo "Logging into Docker"
echo $DOCKER_TOCKEN | docker login --username $DOCKER_USERNAME --password-stdin

echo "Pushing $version"
docker push mpassarge/nhl-system:$version

echo "Pushing latest"
docker push mpassarge/nhl-system:latest

echo "Logging out"
docker logout