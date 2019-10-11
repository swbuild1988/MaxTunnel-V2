FROM java:8
VOLUME /tmp
COPY target/maxtunnel-eureka-1.0.0.jar maxtunnel-eureka.jar
EXPOSE 1025
ENTRYPOINT ["java","-jar","maxtunnel-eureka.jar"]