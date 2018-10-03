sudo docker build -t rhecruta/banco banco/

cd projeto/
mvn clean package

sudo docker build -t rhecruta/app .

sudo docker run -d  -p 5433:5432 --name bdrhecruta rhecruta/banco
sudo docker run  -p 8081:8080 --link bdrhecruta:host-banco rhecruta/app
