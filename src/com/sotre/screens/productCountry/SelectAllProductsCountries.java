package com.sotre.screens.productCountry;

import com.sotre.entities.Product_Country;
import com.sotre.repos.Product_Country_Repo;
import java.util.List;

public class SelectAllProductsCountries {

    public static void main(String[] args) {
        System.out.println("All Products Countries Records are :");

        Product_Country_Repo repo = new Product_Country_Repo();
        List<Product_Country> productCountry = repo.getAllProductCountry();

        System.out.println(productCountry);

    }

}
