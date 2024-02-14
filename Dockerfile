FROM openjdk:17 

ADD ./target/books-app.jar books-app.jar
EXPOSE 9091
ENTRYPOINT [ "java","-jar","books-app.jar" ]