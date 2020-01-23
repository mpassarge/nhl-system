#!/bin/bash

http_code=$(curl --silent -L -o /dev/null -I --write-out %{http_code} https://hub.docker.com/v2/repositories/mpassarge/nhl-system/tags/$1)

if [ $http_code -eq 200 ]; then
  echo "Version $1 already deployed"
  exit -1
else
  echo "Version, $1, hasn't been deployed, continuing with docker deployment"
fi