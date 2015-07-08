package rule.impl;

import player.Player;
import round.Round;
import rule.Rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TournamentHeadsUpRule implements Rule {

    private final List<Player> players;

    public TournamentHeadsUpRule(List<Player> players) {
        this.players = players;
    }

    @Override
    public List<Player> go() {
        return recursivePlay(players);
    }

    private List<Player> recursivePlay(List<Player> players) {

        if (players.size() == 1) {
            return players;
        }

        List<Player> result = new ArrayList<>();

        if (players.size() == 0) {
            return result;
        }

        Round round;
        List<Player> winners = new ArrayList<>();
        List<Player> losers = new ArrayList<>();
        for (int i = 1; i < players.size(); i += 2) {
            round = new Round(Arrays.asList(players.get(i), players.get(i - 1)));
            round.play();
            winners.addAll(round.getWinners());
            losers.addAll(round.getLosers());
        }
        result.addAll(recursivePlay(winners));
        result.addAll(recursivePlay(losers));
        return result;
    }
}
