package com.sotre.screens.productCountry;

import com.sotre.entities.Product_Country;
import com.sotre.repos.Product_Country_Repo;
import javax.swing.JOptionPane;

public class SelectProductCountry {

    public static void main(String[] args) {
        String productId = JOptionPane.showInputDialog("Please enter Product ID ");

        Product_Country_Repo repo = new Product_Country_Repo();
        Product_Country prCountry = repo.getProductCountryByFK(Integer.parseInt(productId)); //

        System.out.println(prCountry.getProductCountryQty());

    }
}
