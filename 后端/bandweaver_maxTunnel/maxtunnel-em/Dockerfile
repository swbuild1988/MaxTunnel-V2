FROM java:8
VOLUME /tmp
COPY target/maxtunnel-em-1.0.0.jar maxtunnel-em.jar
EXPOSE 4000
ENTRYPOINT ["java","-jar","maxtunnel-em.jar"]