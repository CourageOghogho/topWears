FROM openjdk:17
EXPOSE 8080
ADD target/fashionapp.jar fashionapp.jar
ENTRYPOINT ["java","-jar","/fashionapp.jar"]

#./mvnw clean package -DskipTests to build