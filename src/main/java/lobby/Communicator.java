package lobby;

import round.Round;

import java.util.Scanner;

class Communicator {

    private final static String PATH = "msg/";
    private final static String FORMAT = ".txt";
    private final static int TIME = 50;

    void say(String s) {
        try (Scanner fs = new Scanner(Round.class.getClassLoader().getResourceAsStream(PATH + s + FORMAT))) {
            while (fs.hasNext()) {
                System.out.println(fs.nextLine());
                try {
                    Thread.sleep(TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
