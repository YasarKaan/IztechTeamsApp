package menus;

import entities.Academician;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public static int academicianMenu() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What would you like to do?");
            System.out.println("1- Add a team");
            System.out.println("2- Remove a team");
            System.out.println("3- Update a team");
            System.out.println("-1 for exit 0 for log out");
            System.out.println("Please enter a number: ");
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please write an valid number!");
        }
        return -2;
    }

    public static int updateTeamMenuForAcademician() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("What would you like to do?");
            System.out.println("1- Adding Meeting Channel");
            System.out.println("2- Removing Meeting Channel");
            System.out.println("3- Update a Meeting Channel");
            System.out.println("4- Adding a member to a team");
            System.out.println("5- Removing a member from team");
            System.out.println("6- Updating a member as a team owner");
            System.out.println("7- Monitoring a team");
            System.out.println("8- Find students and academician amounts in team");
            System.out.println("-1 for exit 0 for log out");
            System.out.println("Please enter a number: ");
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please write a valid number!");
        }
        return -2;
    }

    public static int updateChannelMenu() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("What would you like to do?");
            System.out.println("1- Adding a participant to a Meeting Channel");
            System.out.println("2- Removing a participant from a Meeting Channel");
            System.out.println("3- Update Meeting day and time ");
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please write a valid number!");
        }
        return -2;
    }

    public static int studentMenu() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What would you like to do?");
            System.out.println("1- Monitoring a team");
            System.out.println("2- Find students and academician amounts in team");
            System.out.println("-1 for exit 0 for log out");
            System.out.println("Please enter a number: ");
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Please write an valid number!");
        }
        return -2;
    }
}