package com.bl.tictactoe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    // char[] index =  new char[10];
    Scanner input = new Scanner(System.in);
    char userLetter, computerLetter;
    int count = 0;
    char[] index = new char[10];

    public void Board() {
        for (int i = 1; i < index.length; i++) {
            index[i] = ' ';
        }
    }

    public void showBoard() {
        System.out.println(index[1] + "   " + " | " + index[2] + "  " + " | " + index[3] + " " + "\n" +
                index[4] + "   " + " | " + index[5] + "  " + " | " + index[6] + " " + " " + "\n" +
                index[7] + "   " + " | " + index[8] + "  " + " | " + index[9] + " ");
    }

    public void selectOption() {
        System.out.println("Select your letter : X?O");
        userLetter = input.next().toUpperCase().charAt(0);
        computerLetter = (userLetter == 'X' ? 'O' : 'X');
        System.out.println("User Letter: " + userLetter + ", " + "Computer Letter: " + computerLetter);
    }

    //    public void selectLocation() {
//        System.out.println("select location from 1-9");
//        int userMove = input.nextInt();
//        do {
//            if (userMove > index.length - 1) {
//                System.out.println("please select proper location from 1-9");
//                userMove = input.nextInt();
//            }
//        } while (userMove >= index.length);
//
//        for (int i = 0; i < index.length; i++) {
//            if (userMove == i && index[i] == ' ') {
//                index[i] = userLetter;
//                showBoard();
//                break;
//            }
    //      }
    //}
    public char selectPlayer() {
        int coinFlip = (int) ((Math.random() * 10) % 2);
        char player = (coinFlip == 1) ? userLetter : computerLetter;
        System.out.println("Starting Player is " + player);
        return player;
    }
    public void selectLocation(char turn) {
        if (turn == computerLetter) {
            System.out.println("computer turn to play");
            computerTurn(turn);
        }
        System.out.println("select location from 1-9");
        int userMove = input.nextInt();
        userTurn(userMove, turn);
    }

    public void userTurn(int userMove, char turn) {
        if (userMove > index.length - 1) {
            System.out.println("Enter correct location");
            userTurn(userMove, turn);
        }
        for (int i = 0; i < index.length; i++) {
            if (userMove == i && index[i] == ' ') {
                index[i] = userLetter;
                count++;
                showBoard();
                checkNextMove(turn);
                break;
            } else if (userMove == i && index[i] != ' ') {
                System.out.println("Location already used");
                selectLocation(turn);
            }
        }
        selectLocation(computerLetter);
    }

    public void computerTurn(char turn) {
        Random rand = new Random();
        int pos = rand.nextInt(9) + 1;
        for (int i = 0; i < index.length; i++) {
            if (pos == i && index[i] == ' ') {
                index[i] = computerLetter;
                count++;
                showBoard();
                checkNextMove(turn);
                break;
            } else if (pos == i && index[i] != ' ') {
                //   System.out.println("Location already used");
                computerTurn(turn);
            }
        }
        selectLocation(userLetter);
    }

    public void checkNextMove(char turn) {
        for (int i = 1; i < 8; i = i + 3) {
            if (index[i] == turn && index[i + 1] == turn && index[i + 2] == turn) {
                System.out.println("winner is " + turn);
                System.exit(0);
            }
        }

        for (int i = 1; i < 4; i = i + 1) {
            if (index[i] == turn && index[i + 3] == turn && index[i + 6] == turn) {
                System.out.println("winner is " + turn);
                System.exit(0);
            }
        }

        if (index[1] == turn && index[5] == turn && index[9] == turn) {
            System.out.println("winner is " + turn);
            System.exit(0);
        } else if (index[3] == turn && index[5] == turn && index[7] == turn) {
            System.out.println("winner is " + turn);
            System.exit(0);
        } else {
            for (int i = 1; i < index.length; i++) {
                if (index[i] == ' ') {
                    selectLocation((turn == computerLetter) ? userLetter : computerLetter);
                }
                if (count == 9) {
                    System.out.println("draw and Thank you");
                    System.exit(0);
                }
            }

        }

    }

}