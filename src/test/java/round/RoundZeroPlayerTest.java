package round;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RoundZeroPlayerTest {

    private Round round;

    @Before
    public void initialize() {
        round = new Round(Arrays.asList());
        round.play();
    }

    @Test
    public void testPlay() throws Exception {
        round.play();
        round.play();
        round.play();
        assertThat(Arrays.asList(), is(round.getWinners()));
        assertThat(Arrays.asList(), is(round.getLosers()));
        assertThat(true, is(round.isFinalRound()));
    }

    @Test
    public void testIsFinalRound() throws Exception {
        assertThat(true, is(round.isFinalRound()));
    }

    @Test
    public void testGetWinners() throws Exception {
        assertThat(Arrays.asList(), is(round.getWinners()));
    }

    @Test
    public void testGetLosers() throws Exception {
        assertThat(Arrays.asList(), is(round.getLosers()));
    }
}
