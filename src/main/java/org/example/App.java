package org.example;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Text: ");
        String text = scanner.nextLine();
        PasswordValidator passwordValidator = new PasswordValidator();
        System.out.println(passwordValidator.validatePasswords(text));
    }
}
