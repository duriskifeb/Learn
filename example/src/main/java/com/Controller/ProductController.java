package com.Controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;

import com.DAO.ProductDAO;
import com.Model.Product;
import com.View.ProductJFrame;

public class ProductController {
    private ProductJFrame view;
    ProductDAO pdao = new ProductDAO();

    public ProductController(ProductJFrame view) {
        this.view = view;
        refreshTable();
    }

    public void addProduct() {
        String name = view.getProductName();
        double price = view.getProductPrice();
    }

    public void updateProduct() {
        String name = view.getProductName();
        double price = view.getProductPrice();
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow != -1) {
            int id = Integer.parseInt(view.getTable().getValueAt(selectedRow, 0).toString());
        }
    }

    public void deleteProduct() {
        int selectedRow = view.getTable().getSelectedRow();
        if (selectedRow != -1) {
            int id = Integer.parseInt(view.getTable().getValueAt(selectedRow, 0).toString());
        }
    }

    public void refreshTable() {
        List<Product> products = pdao.getAllProduct();
        DefaultTableModel model = (DefaultTableModel) view.getTable().getModel();
        model.setRowCount(0);

        for (Product p: products) {
            model.addRow(new Object[]{p.getId(), p.getName(), p.getPrice()});
        }
    }
}