Simple http service on port 8080. Produces and tries to listen topics "kafka.testing.n1-4" and "kafka.testing.unauthorized".

/ - n1-4
/error - unauthorized

Set enviroment variable TESTING_KAFKA_AUTH_SERVER to kafaka server (default 192.168.99.100:9092).