package com.pipelinetools.config;

public class BuildToolConfig {
    public static final String[] SUPPORTED_BUILD_TOOLS = {"Maven", "Gradle", "npm"};
    
    public static String getCommandPrefix(String buildTool) {
        return switch (buildTool) {
            case "Maven" -> "mvn";
            case "Gradle" -> "./gradlew";
            case "npm" -> "npm run";
            default -> throw new IllegalArgumentException("Unsupported build tool: " + buildTool);
        };
    }
}
