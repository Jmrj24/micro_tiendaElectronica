FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/sales-0.0.1.jar
COPY ${JAR_FILE} app_sales.jar
ENTRYPOINT ["java", "-jar", "app_sales.jar"]