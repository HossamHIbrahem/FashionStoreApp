package com.sotre.screens.productCountry;

import com.sotre.repos.Product_Country_Repo;
import javax.swing.JOptionPane;

public class DeleteProductCountry {

    public static void main(String[] args) {

        String productId = JOptionPane.showInputDialog("Please enter Product ID ");

        Product_Country_Repo repo = new Product_Country_Repo();
        repo.delete(Integer.parseInt(productId));
        System.out.println("Record deleted successfully");

    }
}
