# Build JAR
FROM maven:3.9.4-eclipse-temurin-17 AS builder
WORKDIR /app

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN mvn -B -ntp dependency:go-offline

COPY src ./src
RUN mvn -B -ntp package -DskipTests

# Run JAR
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar

# copy ISO CSV file
COPY src/main/resources/iso_currency_codes_only.csv /app/iso.csv

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
