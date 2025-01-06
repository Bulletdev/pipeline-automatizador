package com.pipelinetools.gui;

import com.pipelinetools.config.BuildToolConfig;
import com.pipelinetools.model.FormData;
import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

public class FormPanel extends JPanel {
    private final JTextField projectNameField;
    private final JTextField repoUrlField;
    private final JTextField branchField;
    private final JComboBox<String> buildToolCombo;
    private final JTextArea commandsArea;
    private final JTextField dockerfilePathField;
    private final JCheckBox dockerizeCheck;
    private final JButton createPipelineButton;

    public FormPanel(Consumer<FormData> onSubmit) {
        setLayout(new GridBagLayout());
        
        projectNameField = new JTextField(20);
        repoUrlField = new JTextField(20);
        branchField = new JTextField(20);
        branchField.setText("main");
        buildToolCombo = new JComboBox<>(BuildToolConfig.SUPPORTED_BUILD_TOOLS);
        commandsArea = new JTextArea(5, 20);
        dockerfilePathField = new JTextField(20);
        dockerizeCheck = new JCheckBox("Include Docker Configuration");
        createPipelineButton = new JButton("Create Pipeline");
        
        initializeComponents();
        layoutComponents();
        setupActions(onSubmit);
    }

    private void initializeComponents() {
        // Configurar área de comandos
        commandsArea.setText("clean\ncompile\ntest\npackage");
        commandsArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        // Configurar campo do Dockerfile
        dockerfilePathField.setEnabled(false);
        
        // Configurar checkbox do Docker
        dockerizeCheck.addActionListener(e -> 
            dockerfilePathField.setEnabled(dockerizeCheck.isSelected()));
    }

    private void layoutComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        // Adicionar componentes ao form
        addFormRow("Project Name:", projectNameField, gbc, 0);
        addFormRow("Repository URL:", repoUrlField, gbc, 1);
        addFormRow("Branch:", branchField, gbc, 2);
        addFormRow("Build Tool:", buildToolCombo, gbc, 3);
        
        // Adicionar área de comandos
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(new JLabel("Build Commands:"), gbc);
        
        gbc.gridy = 5;
        add(new JScrollPane(commandsArea), gbc);

        // Adicionar configuração Docker
        gbc.gridy = 6;
        add(dockerizeCheck, gbc);

        gbc.gridy = 7;
        gbc.gridwidth = 1;
        add(new JLabel("Dockerfile Path:"), gbc);
        gbc.gridx = 1;
        add(dockerfilePathField, gbc);

        // Adicionar botão
        gbc.gridy = 8;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(createPipelineButton, gbc);
    }

    private void addFormRow(String label, JComponent component, GridBagConstraints gbc, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 1;
        add(new JLabel(label), gbc);
        gbc.gridx = 1;
        add(component, gbc);
    }

    private void setupActions(Consumer<FormData> onSubmit) {
        createPipelineButton.addActionListener(e -> {
            FormData formData = new FormData(
                projectNameField.getText().trim(),
                repoUrlField.getText().trim(),
                branchField.getText().trim(),
                (String) buildToolCombo.getSelectedItem(),
                commandsArea.getText().trim(),
                dockerizeCheck.isSelected(),
                dockerfilePathField.getText().trim()
            );
            onSubmit.accept(formData);
        });
    }
}