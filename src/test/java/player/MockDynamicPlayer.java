package player;

import java.util.List;

public class MockDynamicPlayer implements Player {

    private final String name;
    private final List<Hand> list;
    private int index;

    public MockDynamicPlayer(String name, List<Hand> list) {
        this.name = name;
        this.list = list;
        index = -1;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public Hand getHand() {
        return list.get(index);
    }

    @Override
    public String makeAChoice() {
        index++;
        return null;
    }

    @Override
    public String toString() {
        return "MockDynamicPlayer{" +
                "name='" + name + '\'' +
                '}';
    }
}
