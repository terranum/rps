package player.impl;

import player.Hand;
import player.Player;

import java.util.concurrent.ThreadLocalRandom;

public class ComputerPlayer implements Player {

    private final static String COMPUTER = "Computer";

    private final String name;
    private Hand hand;
    private static int count = 0;

    public ComputerPlayer() {
        count++;
        this.name = COMPUTER + count;
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
        int randomId = ThreadLocalRandom.current().nextInt(Hand.values().length);
        hand = Hand.values()[randomId];
        return String.valueOf(randomId);
    }

    public static void reset() {
        count = 0;
    }
}
