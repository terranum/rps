package round;

import org.junit.Before;
import org.junit.Test;
import player.Hand;
import player.MockPlayer;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Round2PlayersWinTest {

    private Round round;

    @Before
    public void initialize() {
        round = new Round(Arrays.asList(
                new MockPlayer("MPlayer01", Hand.ROCK), new MockPlayer("MPlayer02", Hand.PAPER)
        ));
        round.play();
    }

    @Test
    public void testPlay() throws Exception {
        round.play();
        round.play();
        round.play();
        assertThat(Arrays.asList(
                new MockPlayer("MPlayer02", Hand.PAPER)).toString(), is(round.getWinners().toString()
        ));
        assertThat(Arrays.asList(
                new MockPlayer("MPlayer01", Hand.ROCK)).toString(), is(round.getLosers().toString()
        ));
        assertThat(true, is(round.isFinalRound()));
    }

    @Test
    public void testIsFinalRound() throws Exception {
        assertThat(true, is(round.isFinalRound()));
    }

    @Test
    public void testGetWinners() throws Exception {
        assertThat(1, is(round.getWinners().size()));
    }

    @Test
    public void testGetLosers() throws Exception {
        assertThat(1, is(round.getLosers().size()));
    }
}
