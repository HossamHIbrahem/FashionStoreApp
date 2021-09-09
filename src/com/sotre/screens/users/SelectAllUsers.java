package com.sotre.screens.users;

import com.sotre.entities.Users;
import com.sotre.repos.UsersRepo;
import java.util.List;

public class SelectAllUsers {

    public static void main(String[] args) {
        
        System.out.println("All Users Records are :");

        UsersRepo repo = new UsersRepo();
        List<Users> users = repo.getAllUsers();

        System.out.println(users); // Print All Records in Users DB

    }

}
