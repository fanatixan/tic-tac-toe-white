package io.fejer.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.function.Consumer;
import java.util.function.IntSupplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@DisplayName("Game")
class GameTest {

    Board board;
    Game game;

    @BeforeEach
    void setup() {
        board = new Board();
        game = new Game(board);
    }

    @DisplayName("Board printing")
    @Nested
    class BoardPrinting {

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

        @DisplayName("GIVEN game WHEN printing THEN the board is printed")
        @Test
        void givenNewGameWhenPrintingThenXMovesIsPrinted() {
            // given
            Board board = mock(Board.class);
            game = new Game(board);
            when(board.print()).thenReturn("<board>");

            // when
            String message = game.print();

            // then
            assertThat(message).contains("<board>");
        }
    }

    @DisplayName("State printing")
    @Nested
    class StatePrinting {
        @DisplayName("GIVEN a new game WHEN printing THEN the message 'Player X moves' is printed")
        @Test
        void givenNewGameWhenPrintingThenXMovesIsPrinted() {
            // given

            // when
            String message = game.print();

            // then
            assertThat(message).contains("Player X moves");
        }

        @DisplayName("GIVEN one step WHEN printing THEN the message 'Player O moves' is printed")
        @Test
        void givenOneStepWhenPrintingThenXMovesIsPrinted() {
            // given
            game.step(0);

            // when
            String message = game.print();

            // then
            assertThat(message).contains("Player O moves");
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

        @DisplayName("Draw")
        @Nested
        class Draw {

            @DisplayName("GIVEN a full board without winner WHEN printing THEN the message 'Draw' is printed")
            @Test
            void givenFullBoardWithoutWinnerWhenPrintingThenDrawIsPrinted() {
                // given
                board.set(0, 'X');
                board.set(1, 'X');
                board.set(5, 'X');
                board.set(6, 'X');
                board.set(8, 'X');
                board.set(2, 'O');
                board.set(3, 'O');
                board.set(4, 'O');
                board.set(7, 'O');

                // when
                String message = game.print();

                // then
                assertThat(message).contains("Draw");
            }

        }
    }

    @DisplayName("Steps")
    @Nested
    class Steps {

        @DisplayName("GIVEN new game WHEN stepping to the center THEN it's player X's turn")
        @Test
        void givenNewGameWhenSteppingToTheCenterThenItsPlayerXTurn() {
            // given

            // when
            game.step(4);

            // then
            assertThat(board.get(4)).isEqualTo('X');
        }

        @DisplayName("GIVEN new game WHEN stepping to the bottom THEN it's player X's turn")
        @Test
        void givenNewGameWhenSteppingToTheBottomThenItsPlayerXTurn() {
            // given

            // when
            game.step(7);

            // then
            assertThat(board.get(7)).isEqualTo('X');
        }

        @DisplayName("GIVEN one step WHEN stepping to the bottom THEN it's player O's turn")
        @Test
        void givenOneStepWhenSteppingToTheBottomThenItsPlayerOTurn() {
            // given
            game.step(3);

            // when
            game.step(0);

            // then
            assertThat(board.get(0)).isEqualTo('O');
        }

        @DisplayName("GIVEN two steps WHEN stepping to the bottom THEN it's player X's turn")
        @Test
        void givenTwoStepsWhenSteppingToTheBottomThenItsPlayerXTurn() {
            // given
            game.step(1);
            game.step(6);

            // when
            game.step(8);

            // then
            assertThat(board.get(8)).isEqualTo('X');
        }

    }

    @DisplayName("Rounds")
    @Nested
    class Rounds {

        Bot bot;

        @Mock
        IntSupplier random;

        @Mock
        Consumer<String> printer;

        @BeforeEach
        void setup() {
            MockitoAnnotations.openMocks(this);
            bot = new Bot(board, random);
        }

        @DisplayName("WHEN starting a game THEN it stops when X wins")
        @Test
        void whenStartingThenItStopsWhenXWins() {
            // given
            when(random.getAsInt())
                    .thenReturn(0)
                    .thenReturn(3)
                    .thenReturn(1)
                    .thenReturn(4)
                    .thenReturn(2);

            // when
            game.start(bot, printer);

            // then
            assertThat(game.print()).contains("Player X won");
            verify(random, times(5)).getAsInt();
        }

        @DisplayName("WHEN starting a game THEN it stops when O wins")
        @Test
        void whenStartingThenItStopsWhenOWins() {
            // given
            when(random.getAsInt())
                    .thenReturn(0)
                    .thenReturn(4)
                    .thenReturn(1)
                    .thenReturn(2)
                    .thenReturn(5)
                    .thenReturn(8)
                    .thenReturn(7)
                    .thenReturn(6);

            // when
            game.start(bot, printer);

            // then
            assertThat(game.print()).contains("Player O won");
            verify(random, times(8)).getAsInt();
        }

        @DisplayName("WHEN starting a game THEN it stops when it's a draw")
        @Test
        void whenStartingThenItStopsWhenItsADraw() {
            // given
            when(random.getAsInt())
                    .thenReturn(0)
                    .thenReturn(2)
                    .thenReturn(1)
                    .thenReturn(3)
                    .thenReturn(5)
                    .thenReturn(4)
                    .thenReturn(6)
                    .thenReturn(7)
                    .thenReturn(8);

            // when
            game.start(bot, printer);

            // then
            assertThat(game.print()).contains("Draw");
            verify(random, times(9)).getAsInt();
        }

        @DisplayName("WHEN starting a game THEN it prints every step")
        @Test
        void whenStartingThenItPrintsEveryStep() {
            // given
            when(random.getAsInt())
                    .thenReturn(0)
                    .thenReturn(3)
                    .thenReturn(1)
                    .thenReturn(4)
                    .thenReturn(2);

            // when
            game.start(bot, printer);

            // then
            verify(printer, times(6)).accept(any());
        }

    }

}
