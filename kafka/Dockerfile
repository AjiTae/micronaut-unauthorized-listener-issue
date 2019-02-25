FROM solsson/kafka
COPY /build/libs/kafka-testing-authorize-1.0-SNAPSHOT.jar libs/
COPY docker/kafka-service.sh bin/
RUN chmod a+x bin/kafka-service.sh
EXPOSE 9092/tcp
EXPOSE 2181/tcp
ENTRYPOINT [ "bin/kafka-service.sh" ]