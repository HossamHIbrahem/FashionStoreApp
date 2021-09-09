package com.sotre.screens.users;

import com.sotre.entities.Users;
import com.sotre.repos.UsersRepo;
import javax.swing.JOptionPane;

public class UpdateUsers {

    public static void main(String[] args) {

        String userId = JOptionPane.showInputDialog("Please enter User ID ");
        String userFullName = JOptionPane.showInputDialog("Please enter User Full Name ");
        String userEmail = JOptionPane.showInputDialog("Please enter User Email ");
        String userName = JOptionPane.showInputDialog("Please enter User Name");

        Users users = new Users();

        users.setUserId(Integer.parseInt(userId));
        users.setUserFullName(userFullName);
        users.setUserEmail(userEmail);
        users.setUserName(userName);

        UsersRepo repo = new UsersRepo();

        repo.update(users);
        System.out.println("Record Updated successfully");
    }
}
