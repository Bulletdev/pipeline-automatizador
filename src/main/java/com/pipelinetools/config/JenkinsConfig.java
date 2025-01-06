package com.pipelinetools.config;

public class JenkinsConfig {
    public static String generateJenkinsfile(String branch, String repoUrl, 
                                           String buildTool, String commands,
                                           boolean includeDocker) {
        return String.format("""
            pipeline {
                agent any
                
                stages {
                    stage('Checkout') {
                        steps {
                            git branch: '%s', url: '%s'
                        }
                    }
                    
                    stage('Build') {
                        steps {
                            script {
                                %s
                            }
                        }
                    }
                    
                    %s
                }
            }
            """,
            branch,
            repoUrl,
            generateBuildCommands(buildTool, commands),
            includeDocker ? generateDockerStage() : ""
        );
    }

    private static String generateBuildCommands(String buildTool, String commands) {
        StringBuilder builder = new StringBuilder();
        String commandPrefix = BuildToolConfig.getCommandPrefix(buildTool);

        for (String cmd : commands.split("\n")) {
            cmd = cmd.trim();
            if (!cmd.isEmpty()) {
                builder.append(String.format("sh '%s %s'\n", commandPrefix, cmd));
            }
        }

        return builder.toString();
    }

    private static String generateDockerStage() {
        return """
            stage('Docker Build') {
                steps {
                    script {
                        docker.build("${env.JOB_NAME}:${env.BUILD_NUMBER}")
                    }
                }
            }
            """;
    }
}
