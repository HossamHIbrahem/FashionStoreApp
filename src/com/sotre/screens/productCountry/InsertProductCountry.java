package com.sotre.screens.productCountry;

import com.sotre.entities.Product;
import com.sotre.entities.Product_Country;
import com.sotre.repos.Product_Country_Repo;
import javax.swing.JOptionPane;

public class InsertProductCountry {

    public static void main(String[] args) {

        String productId = JOptionPane.showInputDialog("Please enter Product ID  ");
        String productIdFk = JOptionPane.showInputDialog("Please enter Product ID FK ");
        String countryName = JOptionPane.showInputDialog("Please enter COUNTRY Name");
        String productModel = JOptionPane.showInputDialog("Please enter Product MODEL ");
        String productCountryQty = JOptionPane.showInputDialog("Please enter PRODUCT COUNTRY Qty ");
        

        
        Product_Country productCountry = new Product_Country();
        
        productCountry.setProductId(Integer.parseInt(productId));
        productCountry.setProductIdFK(Integer.parseInt(productIdFk));
        productCountry.setCountryName(countryName);
        productCountry.setProductModel(Integer.parseInt(productModel));
        productCountry.setProductCountryQty(Integer.parseInt(productCountryQty));

        Product_Country_Repo repo = new Product_Country_Repo();
        repo.insert(productCountry);

    }
}
