package com.sotre.screens.users;

import com.sotre.repos.UsersRepo;
import javax.swing.JOptionPane;

public class DeleteUsers {

    public static void main(String[] args) {

        String userId = JOptionPane.showInputDialog("Please enter User ID ");

        UsersRepo repo = new UsersRepo();
        repo.delete(Integer.parseInt(userId));
        System.out.println("Record deleted successfully");

    }
}
