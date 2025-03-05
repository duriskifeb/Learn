package Arsitektur;

import View.PersonView;
import controller.PersonController;

public class App {
    public static void main(String[] args) {
        // System.out.println("Starting");

        PersonView view = new PersonView();
        new PersonController(view);
        view.setVisible(true);
    }
}
