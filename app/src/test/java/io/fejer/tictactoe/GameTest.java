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

        @DisplayName("GIVEN 2 Xs in the first column WHEN printing THEN the message 'Player X won' is not printed")
        @Test
        void givenTwoXMarksInTheFirstColumnWhenPrintingThenXWonIsNotPrinted() {
            // given
            board.set(0, 'X');
            board.set(3, 'X');

            // when
            String message = game.print();

            // then
            assertThat(message).doesNotContain("Player X won");
        }

        @DisplayName("GIVEN 1 X in the bottom left corner WHEN printing THEN the message 'Player X won' is not printed")
        @Test
        void givenAnXMarksInTheBottomLeftWhenPrintingThenXWonIsNotPrinted() {
            // given
            board.set(6, 'X');

            // when
            String message = game.print();

            // then
            assertThat(message).doesNotContain("Player X won");
        }

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

        @DisplayName("GIVEN 3 Xs in the second column WHEN printing THEN the message 'Player X won' is printed")
        @Test
        void givenThreeXMarksInTheSecondColumnWhenPrintingThenXWonIsPrinted() {
            // given
            board.set(1, 'X');
            board.set(4, 'X');
            board.set(7, 'X');

            // when
            String message = game.print();

            // then
            assertThat(message).contains("Player X won");
        }

        @DisplayName("GIVEN 3 Xs in the third column WHEN printing THEN the message 'Player X won' is printed")
        @Test
        void givenThreeXMarksInTheThirdColumnWhenPrintingThenXWonIsPrinted() {
            // given
            board.set(2, 'X');
            board.set(5, 'X');
            board.set(8, 'X');

            // when
            String message = game.print();

            // then
            assertThat(message).contains("Player X won");
        }

        @DisplayName("GIVEN 3 Os in the first column WHEN printing THEN the message 'Player X won' is printed")
        @Test
        void givenThreeOMarksInTheFirstColumnWhenPrintingThenXWonIsPrinted() {
            // given
            board.set(0, 'O');
            board.set(3, 'O');
            board.set(6, 'O');

            // when
            String message = game.print();

            // then
            assertThat(message).contains("Player O won");
        }

    }

    @DisplayName("Winning with a horizontal line")
    @Nested
    class HorizontalWin {

        @DisplayName("GIVEN 3 Xs in the first row WHEN printing THEN the message 'Player X won' is printed")
        @Test
        void givenThreeXMarksInTheFirstRowWhenPrintingThenXWonIsPrinted() {
            // given
            board.set(0, 'X');
            board.set(1, 'X');
            board.set(2, 'X');

            // when
            String message = game.print();

            // then
            assertThat(message).contains("Player X won");
        }

        @DisplayName("GIVEN 3 Os in the second row WHEN printing THEN the message 'Player O won' is printed")
        @Test
        void givenThreeOMarksInTheSecondRowWhenPrintingThenOWonIsPrinted() {
            // given
            board.set(3, 'O');
            board.set(4, 'O');
            board.set(5, 'O');

            // when
            String message = game.print();

            // then
            assertThat(message).contains("Player O won");
        }

        @DisplayName("GIVEN 3 Xs in the third row WHEN printing THEN the message 'Player X won' is printed")
        @Test
        void givenThreeXMarksInTheThirdRowWhenPrintingThenXWonIsPrinted() {
            // given
            board.set(6, 'X');
            board.set(7, 'X');
            board.set(8, 'X');

            // when
            String message = game.print();

            // then
            assertThat(message).contains("Player X won");
        }

    }

    @DisplayName("Winning with a diagonal")
    @Nested
    class DiagonalWin {

        @DisplayName("GIVEN 3 Xs in the forward diagonal WHEN printing THEN the message 'Player X won' is printed")
        @Test
        void givenThreeXMarksInTheForwardDiagonalWhenPrintingThenXWonIsPrinted() {
            // given
            board.set(2, 'X');
            board.set(4, 'X');
            board.set(6, 'X');

            // when
            String message = game.print();

            // then
            assertThat(message).contains("Player X won");
        }

        @DisplayName("GIVEN 3 Os in the backward diagonal WHEN printing THEN the message 'Player O won' is printed")
        @Test
        void givenThreeOMarksInTheBackwardDiagonalWhenPrintingThenOWonIsPrinted() {
            // given
            board.set(0, 'O');
            board.set(4, 'O');
            board.set(8, 'O');

            // when
            String message = game.print();

            // then
            assertThat(message).contains("Player O won");
        }

    }

}
