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
    static Scanner sc = new Scanner(System.in);

    private static String playerName;
    private static String playersCount;
    private static String gameType;

    public static int getPlayerChoice() {
        Communicator.say("choice");
        String result = sc.nextLine();
        while (!result.matches("[0-2]{1}")){
            Communicator.say("choice");
            result = sc.nextLine();
        }
        return Integer.parseInt(result);
    }

    public static void go() {
        if(playerName == null) {
            init();
        }
        choiceGame();
        choicePlayer();
        play();
        rePlay();
    }

    private static void rePlay() {
        Communicator.say("replay");
        String string = sc.nextLine();
        if(string.toUpperCase().equals("Y")){
            go();
        } else {
            close();
        }
    }

    private static void close() {
        sc.close();
        Communicator.say("seeyou");
    }

    private static void play() {
        List<Player> list = new ArrayList<>();
        ComputerPlayer.reset();
        list.add(new HeroPlayer(playerName));
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

    private static Rule createGame(List<Player> list) {
        if (gameType.equals("1")) {
            return new WinnerRule(list);
        }
        if (gameType.equals("2")) {
            return new LoserRule(list);
        }
        if (gameType.equals("3")) {
            return new TournamentRule(list);
        }
        if (gameType.equals("4")) {
            return new TournametHeadsUpRule(list);
        }
        return null;
    }


    private static void choiceGame() {
        Communicator.say("game");
        gameType = sc.nextLine();
        while (!gameType.matches("[1-4]{1}")) {
            Communicator.say("game");
            gameType = sc.nextLine();
        }
    }

    private static void choicePlayer() {
        if (Integer.parseInt(gameType) > 3) {
            Communicator.say("playersPair");
            playersCount = sc.nextLine();
            while (!playersCount.matches("[2,4,6,8]{1}")) {
                Communicator.say("playersPair");
                playersCount = sc.nextLine();
            }
        } else {
            Communicator.say("players");
            playersCount = sc.nextLine();
            while (!playersCount.matches("[2-8]{1}")) {
                Communicator.say("players");
                playersCount = sc.nextLine();
            }
        }
    }

    private static void init() {
        Communicator.say("hello");
        sc.nextLine();
        playerName = sc.nextLine();
        while (playerName.equals("") || playerName.length() > 10) {
            Communicator.say("name");
            playerName = sc.nextLine();
        }
    }
}
