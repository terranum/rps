package rule.impl;

import player.Player;
import round.Round;
import rule.Rule;

import java.util.ArrayList;
import java.util.List;

public class TournamentRule implements Rule {
    List<Player> players;

    public TournamentRule(List<Player> players) {
        this.players = players;
    }


    @Override
    public List<Player> go() {
        return recursivePlay(players);
    }

    private List<Player> recursivePlay(List<Player> players) {

        if(players.size() == 1){
            return players;
        }

        List<Player> result = new ArrayList<>();

        if(players.size() == 0){
            return result;
        }

        Round round = new Round(players);
        round.play();
        result.addAll(recursivePlay(round.getWinners()));
        result.addAll(recursivePlay(round.getLosers()));
        return result;
    }
}
