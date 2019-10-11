FROM java:8
VOLUME /tmp
COPY target/maxtunnel-gateway-1.0.0.jar maxtunnel-gateway.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","maxtunnel-gateway.jar"]