package com.sotre.screens.productCountry;

import com.sotre.entities.Product_Country;
import com.sotre.repos.Product_Country_Repo;
import javax.swing.JOptionPane;

public class UpdateProductCountry {

    public static void main(String[] args) {
        String productId = JOptionPane.showInputDialog("Please enter Product ID ");
        String productIdFk = JOptionPane.showInputDialog("Please enter Product ID FK ");
        String CountryName = JOptionPane.showInputDialog("Please enter Country Name");
        String productModel = JOptionPane.showInputDialog("Please enter Product Model ");
        String productCountryQty = JOptionPane.showInputDialog("Please enter Product Country Qty ");

        Product_Country productCountry = new Product_Country();
        
        productCountry.setProductIdFK(Integer.parseInt(productIdFk));
        productCountry.setCountryName(CountryName);
        productCountry.setProductModel(Integer.parseInt(productModel));
        productCountry.setProductCountryQty(Integer.parseInt(productCountryQty));

        Product_Country_Repo repo = new Product_Country_Repo(); 
        repo.update(productCountry);
        System.out.println("Record Updated successfully");
    }
}
