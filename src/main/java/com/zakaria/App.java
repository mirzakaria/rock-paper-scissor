package com.zakaria;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void showMenu(String[] arr) {
        InputValidation user = new InputValidation();
        System.out.println("Available Moves:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i+1 + " - " + arr[i]);
        }
        System.out.println("0 - exit");
        System.out.println("? - help");
    }

    public static void startApp(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        InputValidation inputValidation = new InputValidation();
        if (!inputValidation.isOddAndMoreThanTwo(args) ||
                !inputValidation.isNotRepeated(Arrays.asList(args))) {
            System.exit(0);
        }
        Computer computer = new Computer();
        String key = "";
        String computerMove = "";
        String hmac;
        key = computer.getKey();
//            System.out.println(key);
        computerMove = computer.generateMove(args);
        hmac = computer.generateHmac("HmacSHA256", computerMove, key);

        System.out.println("HMAC: " + hmac);
//            App.showMenu(args);
        App.showMenu(args);

        int userIn = inputValidation.getUserInputAndValidate(args);
        int comIn = Arrays.asList(args).indexOf(computerMove);

        Result result = new Result();
        result.calculateResult(comIn, userIn, args);
//        System.out.println("Computer move: " + computerMove);

    }

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
//        System.out.println(args[0]);
        App.startApp(args);

    }
}
