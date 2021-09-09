package com.sotre.screens.product;

import com.sotre.repos.ProductRepo;
import javax.swing.JOptionPane;

public class DeleteProduct {

    public static void main(String[] args) {

        String productId = JOptionPane.showInputDialog("Please enter Product ID ");

        ProductRepo repo = new ProductRepo();
        repo.delete(Integer.parseInt(productId));
        System.out.println("Record deleted successfully");

    }
}
