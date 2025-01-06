package main.java.com.pipelinetools.service;

import java.io.File;
import java.io.IOException;

public class GitService {
    public void initializeRepository(String configDir) throws IOException {
        ProcessBuilder builder = new ProcessBuilder("git", "init");
        builder.directory(new File(configDir));
        Process process = builder.start();
        
        try {
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                throw new IOException("Failed to initialize Git repository");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Git initialization was interrupted", e);
        }
    }
}