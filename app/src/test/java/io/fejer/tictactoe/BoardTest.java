package io.fejer.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Board")
class BoardTest {

    Board board;

    @BeforeEach
    void setup() {
        board = new Board();
    }

    @DisplayName("GIVEN an empty board WHEN printing THEN an empty grid is returned")
    @Test
    void givenNewBoardWhenPrintingThenEmptyGridIsReturned() {
        // given

        // when
        String printedBoard = board.print();

        // then
        assertThat(printedBoard).isEqualTo(
                """
                         | |\s
                        -+-+-
                         | |\s
                        -+-+-
                         | |\s
                        """
        );
    }

    @DisplayName("GIVEN an X in the top left WHEN printing THEN mark is printed")
    @Test
    void givenXMarkInTheTopLeftCornerWhenPrintingThenMarkIsPrinted() {
        // given
        board.set(0, 'X');

        // when
        String printedBoard = board.print();

        // then
        assertThat(printedBoard).isEqualTo(
                """
                        X| |\s
                        -+-+-
                         | |\s
                        -+-+-
                         | |\s
                        """
        );
    }

    @DisplayName("GIVEN an X in the top right WHEN printing THEN mark is printed")
    @Test
    void givenXMarkInTheTopRightCornerWhenPrintingThenMarkIsPrinted() {
        // given
        board.set(2, 'X');

        // when
        String printedBoard = board.print();

        // then
        assertThat(printedBoard).isEqualTo(
                """
                         | |X
                        -+-+-
                         | |\s
                        -+-+-
                         | |\s
                        """
        );
    }

    @DisplayName("GIVEN multiple Xs WHEN printing THEN all marks are printed")
    @Test
    void givenMultipleXMarksWhenPrintingThenAllMarksArePrinted() {
        // given
        board.set(4, 'X');
        board.set(8, 'X');
        board.set(5, 'X');

        // when
        String printedBoard = board.print();

        // then
        assertThat(printedBoard).isEqualTo(
                """
                         | |\s
                        -+-+-
                         |X|X
                        -+-+-
                         | |X
                        """
        );
    }

    @DisplayName("GIVEN an O in the bottom left WHEN printing THEN mark is printed")
    @Test
    void givenOMarkInTheBottomLeftCornerWhenPrintingThenMarkIsPrinted() {
        // given
        board.set(6, 'O');

        // when
        String printedBoard = board.print();

        // then
        assertThat(printedBoard).isEqualTo(
                """
                         | |\s
                        -+-+-
                         | |\s
                        -+-+-
                        O| |\s
                        """
        );
    }

}
