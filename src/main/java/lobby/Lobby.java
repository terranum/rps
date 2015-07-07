package lobby;

import player.Player;
import player.impl.ComputerPlayer;
import player.impl.HeroPlayer;
import rule.Rule;
import rule.impl.LoserRule;
import rule.impl.TournamentRule;
import rule.impl.TournametHeadsUpRule;
import rule.impl.WinnerRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lobby {

    private String playerName;
    private String playersCount;
    private String gameType;
    private Scanner sc;
    private Communicator com;

    public Lobby() {
        this.sc = new Scanner(System.in);
        this.com = new Communicator();
    }

    public int getPlayerChoice() {
        com.say("choice");
        String result = sc.nextLine();
        while (!result.matches("[0-2]{1}")) {
            com.say("choice");
            result = sc.nextLine();
        }
        return Integer.parseInt(result);
    }

    public void go() {
        if (playerName == null) {
            init();
        }
        choiceGame();
        choicePlayer();
        play();
        rePlay();
    }

    private void rePlay() {
        com.say("replay");
        String string = sc.nextLine();
        if (string.toUpperCase().equals("Y")) {
            go();
        } else {
            close();
        }
    }

    private void close() {
        sc.close();
        com.say("seeyou");
    }

    private void play() {
        List<Player> list = new ArrayList<>();
        ComputerPlayer.reset();
        list.add(new HeroPlayer(playerName, this));
        for (int i = 0; i < Integer.parseInt(playersCount) - 1; i++) {
            list.add(new ComputerPlayer());
        }

        Rule rule = createGame(list);
        List<Player> stat = rule.go();

        System.out.println();
        for (int i = 0; i < stat.size(); i++) {
            System.out.println((i + 1) + " - " + stat.get(i).getName() + " ");
        }
    }

    private Rule createGame(List<Player> list) {
        switch (gameType) {
            case "1":
                return new WinnerRule(list);
            case "2":
                return new LoserRule(list);
            case "3":
                return new TournamentRule(list);
            case "4":
                return new TournametHeadsUpRule(list);
        }
        return null;
    }


    private void choiceGame() {
        com.say("game");
        gameType = sc.nextLine();
        while (!gameType.matches("[1-4]{1}")) {
            com.say("game");
            gameType = sc.nextLine();
        }
    }

    private void choicePlayer() {
        if (Integer.parseInt(gameType) > 3) {
            com.say("playersPair");
            playersCount = sc.nextLine();
            while (!playersCount.matches("[2,4,6,8]{1}")) {
                com.say("playersPair");
                playersCount = sc.nextLine();
            }
        } else {
            com.say("players");
            playersCount = sc.nextLine();
            while (!playersCount.matches("[2-8]{1}")) {
                com.say("players");
                playersCount = sc.nextLine();
            }
        }
    }

    private void init() {
        com.say("hello");
        sc.nextLine();
        playerName = sc.nextLine();
        while (playerName.equals("") || playerName.length() > 10) {
            com.say("name");
            playerName = sc.nextLine();
        }
    }
}
