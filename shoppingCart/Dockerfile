FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/shoppingcart-0.0.1.jar
COPY ${JAR_FILE} app_shoppingcart.jar
ENTRYPOINT ["java", "-jar", "app_shoppingcart.jar"]