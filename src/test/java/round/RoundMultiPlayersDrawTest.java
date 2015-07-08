package round;

import org.junit.Before;
import org.junit.Test;
import player.Hand;
import player.MockPlayer;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RoundMultiPlayersDrawTest {

    private Round round;

    @Before
    public void initialize() {
        round = new Round(Arrays.asList(
                new MockPlayer("MPlayer01", Hand.ROCK),
                new MockPlayer("MPlayer02", Hand.PAPER),
                new MockPlayer("MPlayer03", Hand.SCISSORS)
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
                        new MockPlayer("MPlayer01", Hand.ROCK),
                        new MockPlayer("MPlayer02", Hand.PAPER),
                        new MockPlayer("MPlayer03", Hand.SCISSORS)
                ).toString(),
                is(round.getLosers().toString()));
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
                        new MockPlayer("MPlayer01", Hand.ROCK),
                        new MockPlayer("MPlayer02", Hand.PAPER),
                        new MockPlayer("MPlayer03", Hand.SCISSORS)
                ).toString(),
                is(round.getLosers().toString()));
    }
}
