# Stage 1: Builder
FROM maven:3.9.4-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy Maven files
COPY pom.xml mvnw ./
COPY .mvn .mvn

# Download dependencies
RUN mvn -B -ntp dependency:go-offline

# Copy source code
COPY src ./src

# Package application without tests
RUN mvn -B -ntp package -DskipTests

# Stage 2: Application
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copy the JAR from the builder
COPY --from=builder /app/target/*.jar app.jar

# Copy resources (CSV file)
COPY src/main/resources/iso_currency_codes_only.csv ./iso_currency_codes_only.csv

# Expose port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java","-jar","app.jar"]
