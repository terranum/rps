package player.impl;

import lobby.Lobby;
import player.Hand;
import player.Player;



public class HeroPlayer implements Player {
    private String name;
    private Hand hand;

    public HeroPlayer(String name) {
        this.name = name;
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
        int playerChoice = Lobby.getPlayerChoice();
        this.hand = Hand.values()[playerChoice];
        return String.valueOf(hand);
    }
}
