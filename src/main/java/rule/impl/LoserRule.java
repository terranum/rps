package rule.impl;

import player.Player;
import round.Round;
import rule.Rule;

import java.util.List;

public class LoserRule implements Rule {
    List<Player> players;

    public LoserRule(List<Player> players) {
        this.players = players;
    }

    @Override
    public List<Player> go() {
        Round round = new Round(players);
        round.play();
        while (round.getLosers().size() != 1){
            round = new Round(round.getLosers());
            round.play();
        }

        return round.getLosers();
    }
}
