package io.fejer.tictactoe;

public class Game {

    private final Board board;

    public Game(Board board) {
        this.board = board;
    }

    public String print() {
        String state = "Player X moves";

        if (board.get(0) == 'X') {
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
