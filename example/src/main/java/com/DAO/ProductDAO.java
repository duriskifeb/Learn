package com.DAO;

import java.util.ArrayList;

import java.util.List;

import com.DatabaseConnection;
import com.Model.Product;
import com.mysql.cj.x.protobuf.MysqlxSql;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class ProductDAO {
    public List<Product> getAllProduct() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Product";
        try (Connection conn = DatabaseConnection.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
            }   
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
}