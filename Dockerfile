FROM openjdk:8-jdk-alpine
EXPOSE 8081
ADD /target/cart-trunk-SNAPSHOT.jar cart.jar
ENTRYPOINT ["java","-jar","cart.jar"]