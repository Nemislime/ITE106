import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class phonebook {
    private static HashMap<String, String> phonebook = new HashMap<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Phonebook");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create UI Components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 5, 5));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel phoneLabel = new JLabel("Phone:");
        JTextField phoneField = new JTextField();

        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        JButton addButton = new JButton("Add/Update");
        JButton searchButton = new JButton("Search");
        JButton deleteButton = new JButton("Delete");
        JButton displayButton = new JButton("Display All");

        // Add Components to Panel
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(phoneLabel);
        panel.add(phoneField);
        panel.add(addButton);
        panel.add(searchButton);
        panel.add(deleteButton);
        panel.add(displayButton);
        panel.add(new JLabel("Output:"));
        panel.add(scrollPane);

        // Add Listeners
        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            if (!name.isEmpty() && !phone.isEmpty()) {
                phonebook.put(name, phone);
                outputArea.setText("Contact added/updated: " + name + " - " + phone);
            } else {
                outputArea.setText("Please enter both name and phone number.");
            }
        });

        searchButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (phonebook.containsKey(name)) {
                outputArea.setText("Found: " + name + " - " + phonebook.get(name));
            } else {
                outputArea.setText("Contact not found.");
            }
        });

        deleteButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (phonebook.containsKey(name)) {
                phonebook.remove(name);
                outputArea.setText("Deleted contact: " + name);
            } else {
                outputArea.setText("Contact not found.");
            }
        });

        displayButton.addActionListener(e -> {
            if (phonebook.isEmpty()) {
                outputArea.setText("Phonebook is empty.");
            } else {
                StringBuilder contacts = new StringBuilder("All Contacts:\n");
                phonebook.forEach((name, phone) -> contacts.append(name).append(" - ").append(phone).append("\n"));
                outputArea.setText(contacts.toString());
            }
        });

        // Add Panel to Frame
        frame.add(panel);
        frame.setVisible(true);
    }
}
