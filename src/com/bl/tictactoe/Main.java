package com.bl.tictactoe;

public class Main {
    public static void main(String[] args) {
        System.out.println("welcome to tic tac toe game");
        TicTacToe game = new TicTacToe();
        game.Board();
        game.showBoard();
        game.selectOption();
    }
}
