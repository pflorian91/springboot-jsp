# https://stackoverflow.com/questions/53375613/why-is-the-java-11-base-docker-image-so-large-openjdk11-jre-slim
FROM azul/zulu-openjdk-alpine:11.0.12

ADD maven/${resulting.service.name} /
ADD maven/*.sh /

RUN chmod 755 /*.sh

EXPOSE 8089
ENTRYPOINT ["/start.sh", "-jar", "${resulting.service.name}"]