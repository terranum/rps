package player.impl;

import lobby.Lobby;
import player.Hand;
import player.Player;

public class HeroPlayer implements Player {

    private final String name;
    private Hand hand;
    private final Lobby lobby;

    public HeroPlayer(String name, Lobby lobby) {
        this.name = name;
        this.lobby = lobby;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Hand getHand() {
        return this.hand;
    }

    @Override
    public String makeAChoice() {
        int playerChoice = lobby.getPlayerChoice();
        this.hand = Hand.values()[playerChoice];
        return String.valueOf(hand);
    }
}
