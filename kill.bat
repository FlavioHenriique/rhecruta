docker kill $(docker container ls -a -q)
docker rmi -f $(docker image ls rhecruta/* -q)

docker rm -f $(docker ps -aq --filter name=bdrhecruta)