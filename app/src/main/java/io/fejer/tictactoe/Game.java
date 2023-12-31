package io.fejer.tictactoe;

import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Game {

    private final Board board;
    private int stepCount;

    public Game(Board board) {
        this.board = board;
    }

    public String print() {
        String state;

        char winner = winner();
        if (winner != Board.EMPTY) {
            state = String.format("Player %c won", winner);
        } else if (isBoardFull()) {
            state = "Draw";
        } else {
            state = String.format("Player %c moves", currentPlayer());
        }

        return board.print() + "\n" + state;
    }

    private char winner() {
        char columnWinner = columnWinner();
        if (columnWinner != Board.EMPTY) {
            return columnWinner;
        }

        char rowWinner = rowWinner();
        if (rowWinner != Board.EMPTY) {
            return rowWinner;
        }

        return diagonalWinner();
    }

    private boolean isBoardFull() {
        return IntStream.range(0, 9)
                .map(board::get)
                .filter(cell -> cell != Board.EMPTY)
                .count() == 9;
    }

    private char columnWinner() {
        char firstColumnWinner = cellsWinner(0, 3, 6);
        if (firstColumnWinner != Board.EMPTY) {
            return firstColumnWinner;
        }

        char secondColumnWinner = cellsWinner(1, 4, 7);
        if (secondColumnWinner != Board.EMPTY) {
            return secondColumnWinner;
        }

        return cellsWinner(2, 5, 8);
    }

    private char rowWinner() {
        char firstRowWinner = cellsWinner(0, 1, 2);
        if (firstRowWinner != Board.EMPTY) {
            return firstRowWinner;
        }

        char secondRowWinner = cellsWinner(3, 4, 5);
        if (secondRowWinner != Board.EMPTY) {
            return secondRowWinner;
        }

        return cellsWinner(6, 7, 8);
    }

    private char diagonalWinner() {
        char forwardDiagonalWinner = cellsWinner(2, 4, 6);
        if (forwardDiagonalWinner != Board.EMPTY) {
            return forwardDiagonalWinner;
        }

        return cellsWinner(0, 4, 8);
    }

    private char cellsWinner(int index1, int index2, int index3) {
        if (board.get(index1) == board.get(index2) && board.get(index1) == board.get(index3) && board.get(index1) != Board.EMPTY) {
            return board.get(index1);
        }

        return Board.EMPTY;
    }

    public void step(int index) {
        board.set(index, currentPlayer());
        stepCount++;
    }

    private char currentPlayer() {
        if (stepCount % 2 == 0) {
            return 'X';
        }

        return 'O';
    }

    public void start(Bot bot, Consumer<String> printer, IntConsumer sleeper) {
        printer.accept(print());
        while (winner() == Board.EMPTY && !isBoardFull()) {
            sleeper.accept(2000);
            step(bot.nextStep());
            printer.accept(print());
        }
    }


}
