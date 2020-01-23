#!/bin/sh

version=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)
http_code=$(curl --silent -L -o /dev/null -I --write-out %{http_code} https://hub.docker.com/v2/repositories/mpassarge/nhl-system/tags/$version)

if [ $http_code -eq 200 ]; then
  echo "Version $version already deployed"
  exit -1
fi