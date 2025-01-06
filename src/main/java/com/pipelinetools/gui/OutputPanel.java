package com.pipelinetools.gui;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {
    private final JTextArea outputArea;

    public OutputPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Output"));
        
        outputArea = new JTextArea(10, 20);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);
    }

    public void appendOutput(String text) {
        outputArea.append(text + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }
}