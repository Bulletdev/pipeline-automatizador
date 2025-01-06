package com.pipelinetools.model;

public class FormData {
    private final String projectName;
    private final String repoUrl;
    private final String branch;
    private final String buildTool;
    private final String commands;
    private final boolean includeDocker;
    private final String dockerfilePath;

    public FormData(String projectName, String repoUrl, String branch, 
                   String buildTool, String commands, boolean includeDocker, 
                   String dockerfilePath) {
        this.projectName = projectName;
        this.repoUrl = repoUrl;
        this.branch = branch;
        this.buildTool = buildTool;
        this.commands = commands;
        this.includeDocker = includeDocker;
        this.dockerfilePath = dockerfilePath;
    }

    // Getters
    public String getProjectName() { return projectName; }
    public String getRepoUrl() { return repoUrl; }
    public String getBranch() { return branch; }
    public String getBuildTool() { return buildTool; }
    public String getCommands() { return commands; }
    public boolean isIncludeDocker() { return includeDocker; }
    public String getDockerfilePath() { return dockerfilePath; }
}