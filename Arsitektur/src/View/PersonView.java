package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class PersonView extends JFrame {

    private JTextField textFirstName = new JTextField(15);
    private JTextField textLastName = new JTextField(15);
    private JTextField textidNumber = new JTextField(15);
    private JButton btnSave = new JButton("save");
    private JButton btnDelete = new JButton("delete");
    private JButton btnUpdate = new JButton("Update");
    private DefaultTableModel tableModel;
    private JTable table;

    public PersonView() {
        setTitle("java GUI MVC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // awal panel input
        JPanel panelInput = new JPanel(new GridLayout(4, 2, 5, 5));
        panelInput.add(new JLabel("First Name"));

        panelInput.add(new JLabel("Last Name"));
        panelInput.add(textLastName);

        panelInput.add(new JLabel("NIM"));
        panelInput.add(textidNumber);

        JPanel panelButton = new JPanel();
        panelButton.add(btnSave);
        panelButton.add(btnDelete);
        panelButton.add(btnUpdate);
        // akhir panel input

        // awal pembuatan table
        String[] columnNames = { "First Name", "Last Name", "NIM" };
        tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table); // ini di masnya gada
        // akhir pembuatan table

        // add Component Table
        add(panelInput, BorderLayout.NORTH);
        add(panelButton, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    // awalan getter settter button
    public String getFirstName() {
        return textFirstName.getText();
    }

    public String getLastName() {
        return textLastName.getText();

    }

    public String getIdNumber() {
        return textFirstName.getText();
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
        return table.getSelectedRow();
    }
}