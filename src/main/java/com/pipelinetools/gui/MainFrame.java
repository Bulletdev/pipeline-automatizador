package com.pipelinetools.gui;

import com.pipelinetools.model.FormData;
import com.pipelinetools.service.PipelineService;
import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final FormPanel formPanel;
    private final OutputPanel outputPanel;
    private final PipelineService pipelineService;

    public MainFrame() {
        setTitle("Pipeline Configuration Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600, 800));
        
        formPanel = new FormPanel(this::createPipeline);
        outputPanel = new com.pipelinetools.gui.OutputPanel();
        pipelineService = new PipelineService(outputPanel::appendOutput);
        
        layoutComponents();
        pack();
        setLocationRelativeTo(null);
    }

    private void createPipeline() {
        createPipeline((FormData) null);
    }



    private void layoutComponents() {
        setLayout(new BorderLayout(10, 10));
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(outputPanel, BorderLayout.CENTER);
        
        add(mainPanel);
    }

    private void createPipeline(FormData formData) {
        pipelineService.createPipeline(formData);
    }
}
