cd C:\Users\Lestat\Developer\rhecruta
docker build -t rhecruta/banco banco/

cd projeto\
mvn clean package

docker build -t rhecruta/app .

cd ..
docker run -d  -p 5433:5432 --name bdrhecruta /banco
docker run  -p 8081:8080 --link bdrhecruta:host-banco rhecruta/app
