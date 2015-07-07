package lobby;

import round.Round;
import java.util.Scanner;

public class Communicator {
    protected void say(String s) {
        try (Scanner fs = new Scanner(Round.class.getClassLoader().getResourceAsStream("msg/" + s + ".txt"))) {
            while (fs.hasNext()) {
                System.out.println(fs.nextLine());
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
