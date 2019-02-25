#!/bin/bash
KAFKA_PATH=/opt/kafka

echo -e "\nauthorizer.class.name=kafka.testing.authorize.SimpleAuthorizer\nadvertised.listeners=PLAINTEXT://${KAFKA_HOST:-192.168.99.100:9092}" >> $KAFKA_PATH/config/server.properties

$KAFKA_PATH/bin/zookeeper-server-start.sh $KAFKA_PATH/config/zookeeper.properties &

while true; do
	$KAFKA_PATH/bin/kafka-server-start.sh $KAFKA_PATH/config/server.properties
	sleep 5
done
