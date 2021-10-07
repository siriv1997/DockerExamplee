# commands

## create docker network
docker network create mongo-network

## start mongodb
sudo docker run -d \
-p 27017:27017 \
-e MONGO_INITDB_ROOT_USERNAME=admin \
-e MONGO_INITDB_ROOT_PASSWORD=password \
--name mongodb \
--network mongo-network \
mongo

## start mongo-express
sudo docker run -d \
-p 8081:8081 \
-e ME_CONFIG_MONGODB_ADMINUSERNAME="admin" \
-e ME_CONFIG_MONGODB_ADMINPASSWORD="password" \
--net mongo-network \
--name mongo-express \
-e  ME_CONFIG_MONGODB_SERVER="mongodb" \
mongo-express


<!-- Docker Secret token 495d699b-8b7d-4b53-b663-d19bf6a604fb -->