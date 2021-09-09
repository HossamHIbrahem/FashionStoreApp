package com.sotre.screens.users;

import com.sotre.entities.Users;
import com.sotre.repos.UsersRepo;
import javax.swing.JOptionPane;

public class InsertUsers {

    public static void main(String[] args) {

        String userId = JOptionPane.showInputDialog("Please enter User ID  ");
        String userFullName = JOptionPane.showInputDialog("Please enter User Full Name");
        String userEmail = JOptionPane.showInputDialog("Please enter User Email");
        String userName = JOptionPane.showInputDialog("Please enter User Name ");
        String userPassword = JOptionPane.showInputDialog("Please enter User Password ");

        Users users = new Users();

        users.setUserId(Integer.parseInt(userId));
        users.setUserFullName(userFullName);
        users.setUserEmail(userEmail);
        users.setUserName(userName);
        users.setUserPassword(Integer.parseInt(userPassword));

        UsersRepo repo = new UsersRepo();
        repo.insert(users);
        System.out.println("Record Inserted successfully");

    }
}
