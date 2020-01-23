
version=$(mvn help:evaluate -Dexpression=project.version -q -DforceStdout)

echo $DOCKER_TOCKEN | docker login --username $DOCKER_USERNAME --password-stdin
docker push mpassarge/nhl-system:$version
docker push mpassarge/nhl-system:latest

docker logout