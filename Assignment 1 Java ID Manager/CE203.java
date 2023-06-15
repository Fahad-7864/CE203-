import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class CE203 extends JFrame {

    private JTextField textField;
    private JTextArea textArea;
    private ArrayList<Id> ids;

    public CE203() {
        ids = new ArrayList<>();

        setLayout(new BorderLayout());
        setTitle("ID Manager");
        setSize(500, 400);
        setLocationRelativeTo(null); // Center the frame

        // North panel for input
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout());
        northPanel.add(new JLabel("Enter ID:"));
        textField = new JTextField(10);
        northPanel.add(textField);
        add(northPanel, BorderLayout.NORTH);

        // South panel for operations
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());
        String[] buttonTitles = {"Add ID", "Display IDs", "Remove ID", "Sort IDs", "Clear List"};
        for (String title : buttonTitles) {
            JButton button = new JButton(title);
            button.addActionListener(new ButtonListener());
            southPanel.add(button);
        }
        add(southPanel, BorderLayout.SOUTH);

        // Center panel for output
        textArea = new JTextArea();
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CE203();
    }

    class Id implements Comparable<Id> {
        String id;

        Id(String id) {
            this.id = id;
        }

        String getId() {
            return id;
        }

        @Override
        public int compareTo(Id o) {
            return this.id.compareTo(o.getId());
        }

        @Override
        public String toString() {
            return id;
        }
    }

    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            String id = textField.getText();

            switch (command) {
                case "Add ID":
                    if (id.matches("\\d{6}")) {
                        ids.add(new Id(id));
                        textArea.append("ID '" + id + "' has been added to the list.\n");
                    } else {
                        textArea.append("The ID '" + id + "' was not added to the list as it is not a valid ID.\n");
                    }
                    break;
                case "Display IDs":
                    textArea.setText("");
                    for (Id idVal : ids) {
                        textArea.append(idVal + "\n");
                    }
                    break;
                case "Remove ID":
                    ids.removeIf(x -> x.getId().equals(id));
                    textArea.append("ID '" + id + "' has been removed from the list.\n");
                    break;
                case "Sort IDs":
                    Collections.sort(ids);
                    textArea.setText("");
                    for (Id idVal : ids) {
                        textArea.append(idVal + "\n");
                    }
                    break;
                case "Clear List":
                    ids.clear();
                    textArea.setText("");
                    textArea.append("The list has been cleared.\n");
                    break;
            }
        }
    }
}
