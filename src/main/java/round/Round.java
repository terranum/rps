package round;

import player.Hand;
import player.Player;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Round {

    private final List<Player> players;
    private List<Player> winners;
    private List<Player> losers;
    private Hand winnerHand;
    private boolean finalRound;

    public Round(List<Player> players) {
        this.players = players;
    }

    public void play() {
        players.stream().forEach(Player::makeAChoice);
        players.stream()
                .forEach(pl -> System.out.print(String.format("%10s", pl.getName())
                        + " - " + String.format("%8s", pl.getHand()) + " "));
        System.out.println();

        Set<Hand> playedHands = players.stream().map(Player::getHand).collect(Collectors.toSet());

        if (playedHands.size() == 2) {
            if (playedHands.contains(Hand.ROCK)) {
                if (playedHands.contains(Hand.PAPER)) {
                    winnerHand = Hand.PAPER;
                } else {
                    winnerHand = Hand.ROCK;
                }
            } else {
                winnerHand = Hand.SCISSORS;
            }
        }

        winners = players.stream()
                .filter(pl -> pl.getHand().equals(winnerHand))
                .collect(Collectors.toList());
        losers = players.stream()
                .filter(pl -> !pl.getHand().equals(winnerHand))
                .collect(Collectors.toList());

        if(winners.size() == 1){
            this.finalRound = true;
        }

    }

    public boolean isFinalRound() {
        return finalRound;
    }

    public List<Player> getWinners() {
        return winners;
    }

    public List<Player> getLosers() {
        return losers;
    }
}
