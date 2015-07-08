package player;

public class MockPlayer implements Player {

    private final String name;
    private final Hand hand;

    public MockPlayer(String name, Hand hand) {
        this.name = name;
        this.hand = hand;
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
        return null;
    }

    @Override
    public String toString() {
        return "MockPlayer{" +
                "name='" + name + '\'' +
                ", hand=" + hand +
                '}';
    }
}
