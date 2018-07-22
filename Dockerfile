FROM openjdk:8-jdk-alpine
EXPOSE 8081
ADD /target/shopping-cart-trunk-SNAPSHOT.jar shopping-cart.jar
ENTRYPOINT ["java","-jar","shopping-cart.jar"]
