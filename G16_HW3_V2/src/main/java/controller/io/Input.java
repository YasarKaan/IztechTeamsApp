package controller.io;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public static int getMenuInput(int size) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();
                if ((input < size) && (input>=0) ) {
                    return input;
                } else {
                    System.out.println("Please write an integer in range");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please write an integer");
            }
        }
    }

    public static String getStringInput(){
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                return scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Please write an integer");
            }
        }
    }

    public static int getIntegerInput(){
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                return scanner.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Please write an integer");
            }
        }
    }
}