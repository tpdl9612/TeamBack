FROM openjdk:17-jdk AS build
WORKDIR /app
COPY build/libs/*.jar ./

FROM openjdk:17-jdk AS runtime
WORKDIR /app
COPY --from=build /app/*.jar ./

EXPOSE 4040
CMD ["java", "-jar", "/app/back-0.0.1.jar"]
