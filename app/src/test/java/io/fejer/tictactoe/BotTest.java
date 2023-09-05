package io.fejer.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@DisplayName("Bot")
class BotTest {

    Bot bot;
    @Mock
    Board board;
    @Mock
    IntSupplier random;


    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        bot = new Bot(board, random);
    }

    @DisplayName("WHEN getting next step THEN random step is returned")
    @Test
    void whenGettingNextStepThenRandomStepIsReturned() {
        // given
        int randomValue = 4;
        when(random.getAsInt()).thenReturn(randomValue);

        // when
        int step = bot.nextStep();

        // then
        assertThat(step).isEqualTo(randomValue);
    }

}
