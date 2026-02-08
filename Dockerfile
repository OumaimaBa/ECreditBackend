# Étape 1 : Build avec Maven
FROM maven:3.9.6-eclipse-temurin-17-alpine AS builder

WORKDIR /build
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# Étape 2 : Runtime
FROM eclipse-temurin:17-jre-alpine

RUN addgroup -S spring && adduser -S spring -G spring

WORKDIR /app

COPY --from=builder /build/target/*.jar app.jar

RUN chown spring:spring app.jar

USER spring:spring

EXPOSE 8080

HEALTHCHECK --interval=30s --timeout=3s --start-period=60s --retries=3 \
  CMD wget --quiet --tries=1 --spider http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["java", "-jar", "app.jar"]
