# -------- BASE STAGE --------
FROM eclipse-temurin:21-jdk AS base
WORKDIR /app

# -------- DEVELOPMENT MODE --------
FROM base AS dev
COPY . /app
RUN ./mvnw dependency:resolve
CMD ["./mvnw", "spring-boot:run"]

# -------- BUILD STAGE (for prod) --------
FROM base AS build
COPY . /app
RUN ./mvnw clean package -DskipTests

# -------- PRODUCTION IMAGE --------
FROM eclipse-temurin:21-jdk AS prod
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
