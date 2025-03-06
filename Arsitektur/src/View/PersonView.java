package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class PersonView extends JFrame {

    private JTextField textFirstName = new JTextField(15);
    private JTextField textLastName = new JTextField(15);
    private JTextField textidNumber = new JTextField(15);
    private JButton btnSave = new JButton("Save");
    private JButton btnDelete = new JButton("Delete");
    private JButton btnUpdate = new JButton("Update");
    private DefaultTableModel tableModel;
    private JTable table;

    public PersonView() {
        setTitle("Java GUI MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(240, 240, 240));

        // Panel Input
        JPanel panelInput = new JPanel(new GridBagLayout());
        panelInput.setBackground(Color.WHITE);

        // menggunakan grid agar tata letak yang bagus hehe
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2); // Mengurangi jarak antar komponen
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST; // Geser ke kiri
        panelInput.add(new JLabel("First Name:"), gbc);
        gbc.gridx = 1;
        panelInput.add(textFirstName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelInput.add(new JLabel("Last Name:"), gbc);
        gbc.gridx = 1;
        panelInput.add(textLastName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelInput.add(new JLabel("NIM:"), gbc);
        gbc.gridx = 1;
        panelInput.add(textidNumber, gbc);

        // Panel Tombol
        JPanel panelButton = new JPanel();
        panelButton.setBackground(Color.WHITE);
        btnSave.setBackground(new Color(34, 177, 76));
        btnSave.setForeground(Color.WHITE);
        btnDelete.setBackground(new Color(237, 28, 36));
        btnDelete.setForeground(Color.WHITE);
        btnUpdate.setBackground(new Color(0, 162, 232));
        btnUpdate.setForeground(Color.WHITE);

        panelButton.add(btnSave);
        panelButton.add(btnDelete);
        panelButton.add(btnUpdate);

        // Tabel
        String[] columnNames = { "First Name", "Last Name", "NIM" };
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        table.setDefaultEditor(Object.class, null); // Nonaktifkan edit langsung
        JScrollPane scrollPane = new JScrollPane(table);

        // Tambahkan Komponen
        add(panelInput, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(panelButton, BorderLayout.SOUTH);
    }

    public String getFirstName() {
        return textFirstName.getText();
    }

    public String getLastName() {
        return textLastName.getText();
    }

    public String getIdNumber() {
        return textidNumber.getText();
    }

    public void setFirstName(String firstName) {
        textFirstName.setText(firstName);
    }

    public void setLastName(String lastName) {
        textLastName.setText(lastName);
    }

    public void setIdNumber(String idNumber) {
        textidNumber.setText(idNumber);
    }

    public void addPersonTable(String firstname, String lastname, String idNumber) {
        tableModel.addRow(new Object[] { firstname, lastname, idNumber });
    }

    public void addSaveListener(ActionListener listener) {
        btnSave.addActionListener(listener);
    }

    public void addDeleteListener(ActionListener DelListener) {
        btnDelete.addActionListener(DelListener);
    }

    public void addUpdateListener(ActionListener Uplistener) {
        btnUpdate.addActionListener(Uplistener);
    }

    public int getSelectRow() {
        return table.getSelectedRow();
    }

    public int removeSelectedRow(int index) {
        tableModel.removeRow(index);
        return index;
    }
}
