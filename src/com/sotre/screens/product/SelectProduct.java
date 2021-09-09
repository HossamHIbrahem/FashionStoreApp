package com.sotre.screens.product;

import com.sotre.entities.Product;
import com.sotre.repos.ProductRepo;
import javax.swing.JOptionPane;

public class SelectProduct {

    public static void main(String[] args) {
        String productId = JOptionPane.showInputDialog("Please enter Product ID ");

        ProductRepo repo = new ProductRepo();
        Product p = repo.getProductByPK(Integer.parseInt(productId));

        System.out.println(p.getProductName());

    }
}
