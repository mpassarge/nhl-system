#!/bin/bash

version=$(mvn help:evaluate --file ./pom.xml -Dexpression=project.version -q -DforceStdout)

echo $version
http_code=$(curl --silent -L -o /dev/null -I --write-out %{http_code} https://hub.docker.com/v2/repositories/mpassarge/nhl-system/tags/$version)

echo $http_code
if [ $http_code -eq 200 ]; then
  echo "Version has been deployed. Exiting"
  exit -1
else
  echo "Version hasn't been deployed."
fi
