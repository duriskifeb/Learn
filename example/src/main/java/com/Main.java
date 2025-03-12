package com;

import com.Controller.ProductController;
import com.Model.Product;
import com.View.ProductJFrame;

public class Main {
    public static void main(String[] args) {
        ProductJFrame view = new ProductJFrame();
        ProductController controller = new ProductController(view);
        view.setVisible(true);
    }
}
