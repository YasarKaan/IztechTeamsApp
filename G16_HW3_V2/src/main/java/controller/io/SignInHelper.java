package controller.io;
import model.user.User;

import java.util.ArrayList;
import java.util.Scanner;

public class SignInHelper {
    public static User signInHelp(ArrayList<User> users, String userName, String password) {
        int check = 0;
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                check++;
                if (user.getPassword().equals(password)) {
                    return user;

                } else {
                    System.out.println("Wrong password!");
                    break;
                }
            }
        }
        if (check == 0) {
            System.out.println("User can not found!");
            return null;
        }
        return null;
    }
}
