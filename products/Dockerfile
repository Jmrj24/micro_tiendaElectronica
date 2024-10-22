FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/products-0.0.1.jar
COPY ${JAR_FILE} app_products.jar
ENTRYPOINT ["java", "-jar", "app_products.jar"]