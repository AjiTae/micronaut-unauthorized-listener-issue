Kafka docker image with custom "authorizer.class.name". Forbids topic named "kafka.testing.unauthorized".

1. gradle build
2. docker build . -t kafka_auth
3. docker run -p 9092:9092 --name kafka_auth --env KAFKA_HOST=`docker-machine ip`:9092 kafka_auth