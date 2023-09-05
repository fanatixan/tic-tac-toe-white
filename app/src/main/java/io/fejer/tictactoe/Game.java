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
        char firstColumnWinner = cellsWinner(0, 3, 6);
        if (firstColumnWinner != Board.EMPTY) {
            return firstColumnWinner;
        }

        char secondColumnWinner = cellsWinner(1, 4, 7);
        if (secondColumnWinner != Board.EMPTY) {
            return secondColumnWinner;
        }

        char thirdColumnWinner = cellsWinner(2, 5, 8);
        if (thirdColumnWinner != Board.EMPTY) {
            return thirdColumnWinner;
        }

        char firstRowWinner = cellsWinner(0, 1, 2);
        if (firstRowWinner != Board.EMPTY) {
            return firstRowWinner;
        }

        return Board.EMPTY;
    }

    private char cellsWinner(int index1, int index2, int index3) {
        if (board.get(index1) == board.get(index2) && board.get(index1) == board.get(index3) && board.get(index1) != Board.EMPTY) {
            return board.get(index1);
        }

        return Board.EMPTY;
    }

}
