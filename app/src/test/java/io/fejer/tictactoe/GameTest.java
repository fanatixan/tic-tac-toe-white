package io.fejer.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Game")
class GameTest {

    Board board;
    Game game;

    @BeforeEach
    void setup() {
        board = new Board();
        game = new Game(board);
    }

    @DisplayName("GIVEN a new game WHEN printing THEN empty board is printed")
    @Test
    void givenNewGameWhenPrintingThenEmptyBoardIsPrinted() {
        // given

        // when
        String message = game.print();

        // then
        assertThat(message).contains("""
                 | |\s
                -+-+-
                 | |\s
                -+-+-
                 | |\s
                """);
    }

    @DisplayName("GIVEN a new game WHEN printing THEN the message 'Player X moves' is printed")
    @Test
    void givenNewGameWhenPrintingThenXMovesIsPrinted() {
        // given

        // when
        String message = game.print();

        // then
        assertThat(message).contains("Player X moves");
    }

    @DisplayName("Winning with a vertical line")
    @Nested
    class VerticalWin {

        @DisplayName("GIVEN 3 Xs in the first column WHEN printing THEN the message 'Player X won' is printed")
        @Test
        void givenThreeXMarksInTheFirstColumnWhenPrintingThenXWonIsPrinted() {
            // given
            board.set(0, 'X');
            board.set(3, 'X');
            board.set(6, 'X');

            // when
            String message = game.print();

            // then
            assertThat(message).contains("Player X won");
        }

    }

}
