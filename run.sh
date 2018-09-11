sudo docker build -t rhecruta/banco banco/

sudo docker run -p 5433:5432 --name bdrhecruta rhecruta/banco
