package io.fejer.tictactoe;

public class Game {

    private final Board board;

    public Game(Board board) {
        this.board = board;
    }

    public String print() {
        String state = "Player X moves";

        char winner = winner();
        if (winner != Board.EMPTY) {
            state = String.format("Player %c won", winner);
        }

        return """
                 | |\s
                -+-+-
                 | |\s
                -+-+-
                 | |\s
                                
                """ + state;
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
        return cellsWinner(2, 4, 6);
    }

    private char cellsWinner(int index1, int index2, int index3) {
        if (board.get(index1) == board.get(index2) && board.get(index1) == board.get(index3) && board.get(index1) != Board.EMPTY) {
            return board.get(index1);
        }

        return Board.EMPTY;
    }

}
