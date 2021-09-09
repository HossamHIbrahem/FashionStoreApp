package com.sotre.screens.product;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import com.sotre.entities.Product;
import com.sotre.repos.ProductRepo;
import java.util.List;
import javax.swing.JOptionPane;

public class SelectAllProducts {

    public static void main(String[] args) {
        
        System.out.println("All Products Records are :");

        ProductRepo repo = new ProductRepo();
        List<Product> product = repo.getAllProducts();

        System.out.println(product);

    }

}
