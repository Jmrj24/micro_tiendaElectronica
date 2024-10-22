FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/shoppingCart-0.0.1.jar
COPY ${JAR_FILE} app_shoppingCart.jar
ENTRYPOINT ["java", "-jar", "app_shoppingCart.jar"]