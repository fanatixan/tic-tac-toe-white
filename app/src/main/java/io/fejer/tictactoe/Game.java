package io.fejer.tictactoe;

public class Game {

    private final Board board;

    public Game(Board board) {
        this.board = board;
    }

    public String print() {
        return """
                 | |\s
                -+-+-
                 | |\s
                -+-+-
                 | |\s
                
                Player X moves
                """;
    }
}
