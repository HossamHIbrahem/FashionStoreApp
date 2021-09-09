package com.sotre.screens;

import com.sotre.entities.Product;
import com.sotre.repos.ProductRepo;
import javax.swing.JOptionPane;

public class UpdateProduct {

    public static void main(String[] args) {
        String productId = JOptionPane.showInputDialog("Please enter Product ID ");
        String productName = JOptionPane.showInputDialog("Please enter Product Name");
        String productPrice = JOptionPane.showInputDialog("Please enter Product Price ");
        String productQty = JOptionPane.showInputDialog("Please enter Product Qty ");

        Product product = new Product();
        
        product.setProductId(Integer.parseInt(productId));
        product.setProductName(productName);
        product.setProductPrice(Integer.parseInt(productPrice));
        product.setProductQty(Integer.parseInt(productQty));

        ProductRepo repo = new ProductRepo();
        repo.update(product);
        System.out.println("Record Updated successfully");
    }
}
