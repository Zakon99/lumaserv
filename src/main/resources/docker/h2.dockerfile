# Quelle: https://github.com/oscarfonts/docker-h2/tree/master/2.3.232
FROM eclipse-temurin:21-jre
ARG H2_VERSION=2.3.232
ADD https://repo1.maven.org/maven2/com/h2database/h2/${H2_VERSION}/h2-${H2_VERSION}.jar /opt/h2/h2.jar
EXPOSE 9092 8082
ENTRYPOINT ["java", "-cp", "/opt/h2/h2.jar", "org.h2.tools.Server", \
            "-tcp", "-tcpAllowOthers", "-tcpPort", "9092", \
            "-ifNotExists"]