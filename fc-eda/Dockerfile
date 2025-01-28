FROM golang:1.20

WORKDIR /app/

RUN apt-get update && apt-get install -y librdkafka-dev -y wget

ENV DOCKERIZE_VERSION v0.6.1
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-linux-amd64-$DOCKERIZE_VERSION.tar.gz

COPY docker-entrypoint.sh /app/docker-entrypoint.sh 
RUN chmod +x /app/docker-entrypoint.sh

CMD ["tail", "-f", "/dev/null"]

#ENTRYPOINT ["/app/docker-entrypoint.sh"]  # Execute o executável diretamente
