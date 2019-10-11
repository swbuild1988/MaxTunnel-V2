FROM java:8
VOLUME /tmp
COPY target/maxtunnel-omm-1.0.0.jar maxtunnel-omm.jar
EXPOSE 6000
ENTRYPOINT ["java","-jar","maxtunnel-omm.jar"]