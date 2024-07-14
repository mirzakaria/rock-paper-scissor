package com.zakaria;

public class Result {
    /*
    The victory is defined as follows -
    half of the next moves in the circle wins,
    half of the previous moves in the circle lose
     */

    public void calculateResult(int comMove, int userMove, String[] args) {
        System.out.println("Your move: " + args[userMove]);
        System.out.println("Computer move: " + args[comMove]);

        int mid = args.length / 2;
        int res = (int) Math.signum((comMove - userMove + mid + args.length) % args.length - mid);
        System.out.println("result" + res);

        if (res < 0) {
            System.out.println("You win!");
        } else if (res > 0) {
            System.out.println("You lose!");
        } else {
            System.out.println("Draw!");
        }

    }



}
