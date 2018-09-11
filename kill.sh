docker kill $(docker container ls -a -q)
docker rmi -f $(docker image ls rhecruta/* -q)

sudo docker rm -f $(sudo docker ps -aq --filter name=bdrhecruta)
sudo docker rm -f $(sudo docker ps -aq --filter name=apirhecruta)
