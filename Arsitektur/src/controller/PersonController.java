package controller;

import View.PersonView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class PersonController {
    // memanggil clas view
    private PersonView view;

    public PersonController(PersonView view) {
        this.view = view;

        // add Event Listener
        this.view.addSaveListener(new SaveListener());
        this.view.addDeleteListener(new DeleteListener());
        this.view.addUpdateListener(new UpdateListener());

    }

    // buat button save Listener
    class SaveListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String firtsName = view.getFirstName();
            String lastName = view.getLastName();
            String idNumber = view.getIdNumber();

            if (firtsName.isEmpty() || lastName.isEmpty() || idNumber.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Data Harus Diisi Semua!");
                return;
            } else {
                view.addPersonTable(lastName, lastName, idNumber);
                view.setFirstName("");
                view.setLastName("");
                view.setIdNumber("");

            }
        }
    }

    // buat button delete
    class DeleteListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            int selectRow = view.getSelectRow();
            if (selectRow == -1) {
                JOptionPane.showMessageDialog(view, "Tolong pilih dulu table mana :)");
                return;
            }
            view.removeSelectedRow(selectRow);
        }
    }

    // buat button update
    class UpdateListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            int selectRow = view.getSelectRow();
            if (selectRow == -1) {
                JOptionPane.showMessageDialog(view, "Tolong pilih table untuk  di update");
                return;
            }
            String firstName = view.getFirstName();
            String lastName = view.getLastName();
            String idNumber = view.getLastName();
            view.removeSelectedRow(selectRow);
            view.addPersonTable(firstName, lastName, idNumber);
        }
    }
}
