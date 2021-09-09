package com.sotre.screens;

import com.sotre.entities.Product;
import com.sotre.entities.Product_Country;
import com.sotre.entities.Users;
import com.sotre.repos.ProductRepo;
import com.sotre.repos.Product_Country_Repo;
import com.sotre.repos.UsersRepo;
import com.store.managers.DBManager;
import javax.swing.JOptionPane;

public class AllTables {

    public static void main(String[] args) {

        Product product = new Product();
        Product_Country productCountry = new Product_Country();
        Users users = new Users();
        ProductRepo repo = new ProductRepo();
        Product_Country_Repo countryRepo = new Product_Country_Repo();
        UsersRepo usersRepo = new UsersRepo();

        System.out.println("Welcome to our Data");
        String service = JOptionPane.showInputDialog("Please enter your request");

        try {
            if (service.equals("Product")) {

                String input = JOptionPane.showInputDialog("Please Enter your Input \n 1- Insert \n 2- Select \n 3-Update \n 4- Delete: ");
                if (Integer.parseInt(input) == 1) {
                    repo.insert(product);
                } else if (Integer.parseInt(input) == 2) {
                    repo.getProductByPK(0);
                } else if (Integer.parseInt(input) == 3) {
                    repo.update(product);
                } else if (Integer.parseInt(input) == 4) {
                    repo.delete(0);
                }
            } 
            else if (service.equals("Product Country")) {
                String input = JOptionPane.showInputDialog("Please Enter your Input 1- Insert \n 2- Select \n 3-Update \n 4- Delete: ");
                if (Integer.parseInt(input) == 1) {
                    countryRepo.insert(productCountry);
                } else if (Integer.parseInt(input) == 2) {
                    countryRepo.getProductCountryByFK(0);
                } else if (Integer.parseInt(input) == 3) {
                    countryRepo.update(productCountry);
                } else if (Integer.parseInt(input) == 4) {
                    countryRepo.delete(0);
                }
            } 
            else if (service.equals("Users")) {
                String input = JOptionPane.showInputDialog("Please Enter your Input 1- Insert \n 2- Select \n 3-Update \n 4- Delete: ");
                if (Integer.parseInt(input) == 1) {
                    usersRepo.insert(users);
                } else if (Integer.parseInt(input) == 2) {
                    usersRepo.getUsersId(0);
                } else if (Integer.parseInt(input) == 3) {
                    usersRepo.update(users);
                } else if (Integer.parseInt(input) == 4) {
                    usersRepo.delete(0);
                }
            }
        } catch (Exception ex) {
            System.out.println("Please enter valid entry");
            ex.printStackTrace();
        } finally {
            System.out.println("Thanks for using our services ...");
        }

    }
}
