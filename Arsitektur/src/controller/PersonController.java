package controller;

import View.PersonView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class PersonController {
    private PersonView view;

    public PersonController(PersonView view) {
        this.view = view;

        //add Event Listener
        this.view.addSaveListener(new saveListener());
        this.view.addDeleteListener(new deleteListener());
        this.view.addUpdateListener(new updateListener());

    }

    // Listener untuk tombol Save
    class SaveListener implements ActionListener {
        
        public void actionPerformed(ActionEvent event) {
            String firstName = view.getFirstName();
            String lastName = view.getLastName();
            String idNumber = view.getIdNumber();

            if (firstName.isEmpty() || lastName.isEmpty() || idNumber.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Harap diisi semua field!", "Peringatan",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(view, "Data berhasil disimpan!", "Sukses",
                        JOptionPane.INFORMATION_MESSAGE);
            }

            view.addPersonTable(firstName, lastName, idNumber);

            view.setFirstName("");
            view.setLastName("");
            view.setIdNumber("");

            class UpdateListener implements ActionListener {
                public void actionPerformed(ActionEvent event) {
                    int selectRow = view.getSelectRow();

                    if (selectRow == -1) {
                        JOptionPane.showMessageDialog(view, "pilih dulu yaa");
                        return;
                    }

                    String firstName = 
                    String lastName = 
                    String idNumber = 
                }
            }

            class deleteListener implements ActionListener {
                public void actionPerformed(ActionEvent event) {
                    int selectRow = view.getSelectRow();

                    if (selectRow == -1) {
                        JOptionPane.showMessageDialog(view, "Please select Line");
                        return;
                    }

                    view.(selectRow);
                }
            }
        }
    }
}
