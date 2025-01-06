package com.pipelinetools.config;

public class DockerConfig {
    public static String generateDockerfile(String buildTool) {
        return switch (buildTool) {
            case "Maven" -> """
                FROM openjdk:22-jdk-slim
                WORKDIR /app
                COPY target/*.jar app.jar
                ENTRYPOINT ["java","-jar","app.jar"]
                """;
            case "Gradle" -> """
                FROM openjdk:22-jdk-slim
                WORKDIR /app
                COPY build/libs/*.jar app.jar
                ENTRYPOINT ["java","-jar","app.jar"]
                """;
            case "npm" -> """
                FROM node:16-alpine
                WORKDIR /app
                COPY package*.json ./
                RUN npm install
                COPY . .
                EXPOSE 3000
                CMD ["npm", "start"]
                """;
            default -> throw new IllegalArgumentException("Unsupported build tool for Dockerfile generation: " + buildTool);
        };
    }
}
