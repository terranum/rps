package player.impl;

import player.Hand;
import player.Player;

public class ComputerPlayer implements Player {
    private String name;
    private Hand hand;
    private static int count = 0;

    public ComputerPlayer() {
        count++;
        this.name = "Computer"+ count;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Hand getHand() {
        return hand;
    }

    @Override
    public String makeAChoice() {
        int randomId = (int) (Math.random() * Hand.values().length);
        hand = Hand.values()[randomId];
        return String.valueOf(randomId);
    }

    public static void reset() {
        count = 0;
    }
}
