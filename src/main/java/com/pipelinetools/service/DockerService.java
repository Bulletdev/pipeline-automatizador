package com.pipelinetools.service;

import com.pipelinetools.config.DockerConfig;
import com.pipelinetools.model.FormData;
import com.pipelinetools.util.FileUtils;
import java.io.IOException;

public class DockerService {
    public void generateDockerfile(String configDir, FormData formData) throws IOException {
        String dockerfileContent = DockerConfig.generateDockerfile(formData.getBuildTool());
        FileUtils.writeFile(configDir + "/Dockerfile", dockerfileContent);
    }
}