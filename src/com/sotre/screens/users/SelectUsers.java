package com.sotre.screens.users;

import com.sotre.entities.Users;
import com.sotre.repos.UsersRepo;
import javax.swing.JOptionPane;

public class SelectUsers {

    public static void main(String[] args) {
        String userId = JOptionPane.showInputDialog("Please enter User ID ");

        UsersRepo repo = new UsersRepo();
        Users users = repo.getUsersId(Integer.parseInt(userId)); //

        System.out.println(users.getUserFullName());

    }
}
