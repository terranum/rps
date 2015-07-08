package rule;

import org.junit.Before;
import org.junit.Test;
import player.Hand;
import player.MockDynamicPlayer;
import player.Player;
import rule.impl.TournamentHeadsUpRule;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TournamentHeadsUpRuleTest {

    private Rule rule;

    @Before
    public void initialize() {
        List<Player> list = Arrays.asList(
                new MockDynamicPlayer("MDP01", Arrays.asList(Hand.PAPER, Hand.PAPER, Hand.ROCK, Hand.SCISSORS)),
                new MockDynamicPlayer("MDP02", Arrays.asList(Hand.ROCK, Hand.PAPER, Hand.ROCK, Hand.SCISSORS)),
                new MockDynamicPlayer("MDP03", Arrays.asList(Hand.PAPER, Hand.PAPER, Hand.PAPER, Hand.ROCK)),
                new MockDynamicPlayer("MDP04", Arrays.asList(Hand.SCISSORS, Hand.SCISSORS, Hand.ROCK, Hand.ROCK))
        );
        rule = new TournamentHeadsUpRule(list);
    }

    @Test
    public void testGo() throws Exception {
        List<Player> list = Arrays.asList(
                new MockDynamicPlayer("MDP04", Arrays.asList(Hand.SCISSORS, Hand.SCISSORS, Hand.ROCK, Hand.ROCK)),
                new MockDynamicPlayer("MDP01", Arrays.asList(Hand.PAPER, Hand.PAPER, Hand.ROCK, Hand.SCISSORS)),
                new MockDynamicPlayer("MDP03", Arrays.asList(Hand.PAPER, Hand.PAPER, Hand.PAPER, Hand.ROCK)),
                new MockDynamicPlayer("MDP02", Arrays.asList(Hand.ROCK, Hand.PAPER, Hand.ROCK, Hand.SCISSORS))
        );

        assertThat(list.toString(),is(rule.go().toString()));
    }
}