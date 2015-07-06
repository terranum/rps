package rule.impl;

import player.Player;
import round.Round;
import rule.Rule;

import java.util.List;

public class WinnerRule implements Rule{
    List<Player> players;

    public WinnerRule(List<Player> players) {
        this.players = players;
    }

    @Override
    public List<Player> go() {
        Round round = new Round(players);
        round.play();
        while (!round.isFinalRound()){
            if(round.getWinners().size() != 0){
                round = new Round(round.getWinners());
            } else {
                round = new Round(round.getLosers());
            }
                round.play();
        }

        return round.getWinners();
    }
}
