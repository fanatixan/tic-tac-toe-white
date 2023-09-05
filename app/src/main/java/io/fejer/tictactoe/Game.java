package io.fejer.tictactoe;

public class Game {

    private final Board board;

    public Game(Board board) {
        this.board = board;
    }

    public String print() {
        String state = "Player X moves";

        if (board.get(0) == board.get(3) && board.get(0) == board.get(6) && board.get(0) != Board.EMPTY) {
            state = String.format("Player %c won", board.get(0));
        }

        if (board.get(1) == board.get(4) && board.get(1) == board.get(7) && board.get(1) == 'X') {
            state = "Player X won";
        }

        if (board.get(2) == board.get(5) && board.get(2) == board.get(8) && board.get(2) == 'X') {
            state = "Player X won";
        }

        return """
                 | |\s
                -+-+-
                 | |\s
                -+-+-
                 | |\s
                                
                """ + state;
    }
}
