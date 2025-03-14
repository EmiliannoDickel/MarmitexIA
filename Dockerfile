FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre

WORKDIR /app

EXPOSE 8080

COPY --from=build /app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
