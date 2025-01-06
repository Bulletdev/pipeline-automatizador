package com.pipelinetools.service;



import com.pipelinetools.config.JenkinsConfig;
import com.pipelinetools.model.FormData;
import com.pipelinetools.util.FileUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Consumer;

public class PipelineService {
    private final Consumer<String> logger;
    private final DockerService dockerService;
    private final main.java.com.pipelinetools.service.GitService gitService;

    public PipelineService(Consumer<String> logger) {
        this.logger = logger;
        this.dockerService = new DockerService();
        this.gitService = new main.java.com.pipelinetools.service.GitService();
    }

    public <FormData> void createPipeline(FormData formData) {
        try {
            com.pipelinetools.model.FormData FormData = null;
            validateInputs(FormData);
            String configDir = createConfigDirectory(String.valueOf(FormData.getClass()));
            
            generateConfigurations(configDir, FormData);

            if (FormData.isIncludeDocker()) {
                dockerService.generateDockerfile(configDir, FormData);
            }

            gitService.initializeRepository(configDir);
            
            logger.accept("Pipeline configuration completed successfully!");
            logger.accept("Configuration files generated in: " + configDir);
        } catch (Exception ex) {
            logger.accept("Error creating pipeline: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void validateInputs(FormData formData) {
        if (formData.getProjectName().isEmpty()) {
            throw new IllegalArgumentException("Project name is required");
        }
        if (formData.getRepoUrl().isEmpty()) {
            throw new IllegalArgumentException("Repository URL is required");
        }
        if (formData.getBranch().isEmpty()) {
            throw new IllegalArgumentException("Branch name is required");
        }
        if (formData.getCommands().isEmpty()) {
            throw new IllegalArgumentException("Build commands are required");
        }
        if (formData.isIncludeDocker() && formData.getDockerfilePath().isEmpty()) {
            throw new IllegalArgumentException("Dockerfile path is required when Docker is enabled");
        }
    }

    private String createConfigDirectory(String projectName) throws IOException {
        String configDir = "pipeline-configs/" + projectName;
        Files.createDirectories(Paths.get(configDir));
        return configDir;
    }

    private void generateConfigurations(String configDir, FormData formData) throws IOException {
        // Gerar Jenkinsfile
        String jenkinsfileContent = JenkinsConfig.generateJenkinsfile(
            formData.getBranch(),
            formData.getRepoUrl(),
            formData.getBuildTool(),
            formData.getCommands(),
            formData.isIncludeDocker()
        );
        FileUtils.writeFile(configDir + "/Jenkinsfile", jenkinsfileContent);
        
        logger.accept("Generated Jenkinsfile configuration");
        
        // Gerar outros arquivos de configuração se necessário
        if (formData.isIncludeDocker()) {
            logger.accept("Generating Docker configuration...");
        }
    }
}