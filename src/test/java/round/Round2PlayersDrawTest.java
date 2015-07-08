package round;

import org.junit.Before;
import org.junit.Test;
import player.Hand;
import player.MockPlayer;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Round2PlayersDrawTest {

    private Round round;

    @Before
    public void initialize() {
        round = new Round(Arrays.asList(
                new MockPlayer("MPlayer01", Hand.ROCK), new MockPlayer("MPlayer02", Hand.ROCK)
        ));
        round.play();
    }

    @Test
    public void testPlay() throws Exception {
        round.play();
        round.play();
        round.play();
        assertThat(Arrays.asList(), is(round.getWinners()));
        assertThat(Arrays.asList(
                        new MockPlayer("MPlayer01", Hand.ROCK), new MockPlayer("MPlayer02", Hand.ROCK)).toString(),
                is(round.getLosers().toString()
                ));
        assertThat(false, is(round.isFinalRound()));
    }

    @Test
    public void testIsFinalRound() throws Exception {
        assertThat(false, is(round.isFinalRound()));
    }

    @Test
    public void testGetWinners() throws Exception {
        assertThat(Arrays.asList(), is(round.getWinners()));
    }

    @Test
    public void testGetLosers() throws Exception {
        assertThat(Arrays.asList(
                        new MockPlayer("MPlayer01", Hand.ROCK), new MockPlayer("MPlayer02", Hand.ROCK)).toString(),
                is(round.getLosers().toString()
                ));
    }
}
