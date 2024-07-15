package com.zakaria;

import java.util.*;

public class InputValidation {
    public boolean isOddAndMoreThanTwo(String[] arr) {
        if (arr.length < 3) {
            System.out.println("You have entered " + arr.length + " (less than three) string/s.");
            System.out.println("Please enter odd number of non-repeated String(at least three)");
            System.out.println("e.g., [Rock Paper Scissors] or [Rock Paper Scissors Lizard Spock] or [1 2 3 4 5 6 7 8 9] etc.");
            return false;
        } else if ((arr.length & 1) != 1) {
            System.out.println("You have entered " + arr.length + "(even) strings.");
            System.out.println("Please enter odd number of non-repeated String(at least three).");
            System.out.println("e.g., [Rock Paper Scissors] or [Rock Paper Scissors Lizard Spock] or [1 2 3 4 5 6 7 8 9] etc.");
            return false;
        }
        return true;
    }

    public boolean isNotRepeated(List<String> arr) {
        Set<String> uniqueValues = new HashSet<>();
        for (String s : arr) {
            if (!uniqueValues.add(s)) { // Duplicate found!
                System.out.println("You repeated " + s + ".");
                System.out.println("Please enter odd number of non-repeated String(at least three).");
                System.out.println("e.g., [Rock Paper Scissors] or [Rock Paper Scissors Lizard Spock] or [1 2 3 4 5 6 7 8 9] etc.");
                return false;
            }
        }
        return true;
    }

    public int getUserInputAndValidate(String[] args) {
        Help help = new Help();

        Scanner in = new Scanner(System.in);
        System.out.print("Enter your move: ");
        String s = in.nextLine();
        if (s.equals("0")) {
            System.exit(0);
        } else if (s.equals("?")) {
            help.printHelpTable(args);
            System.out.print("Enter your move: ");
            s = in.nextLine();
        }

        int userIn = Integer.parseInt(s) - 1;
        if (userIn >= 0 && userIn < args.length) {
            return userIn;

        } else {
            System.out.println("Wrong move! Try Again");
            App.showMenu(args);
            return getUserInputAndValidate(args);
        }
    }

}
