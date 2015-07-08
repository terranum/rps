package lobby;

import player.Player;
import player.impl.ComputerPlayer;
import player.impl.HeroPlayer;
import rule.Rule;
import rule.impl.LoserRule;
import rule.impl.TournamentRule;
import rule.impl.TournamentHeadsUpRule;
import rule.impl.WinnerRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lobby {

    private static final String NAME = "name";
    private static final String CHOICE = "choice";
    private static final String REPLAY = "replay";
    private static final String SEE_YOU = "seeYou";
    private static final String GAME = "game";
    private static final String HELLO = "hello";
    private static final String PLAYERS = "players";
    private static final String PLAYER_PAIRS = "playerPairs";
    private static final String YES = "Y";

    private static final String REGEX_PLAYER_CHOICE = "[0-2]";
    private static final String REGEX_GAME_CHOICE = "[1-4]";
    private static final String REGEX_PLAYERS_PP_COUNT_CHOICE = "[2,4,6,8]";
    private static final String REGEX_PLAYERS_COUNT_CHOICE = "[2-8]";

    private String playerName;
    private String playersCount;
    private String gameType;
    private final Scanner sc;
    private final Communicator com;


    public Lobby() {
        this.sc = new Scanner(System.in);
        this.com = new Communicator();
    }

    public int getPlayerChoice() {
        com.say(CHOICE);
        String result = sc.nextLine();
        while (!result.matches(REGEX_PLAYER_CHOICE)) {
            com.say(CHOICE);
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
        com.say(REPLAY);
        String string = sc.nextLine();
        if (string.toUpperCase().equals(YES)) {
            go();
        } else {
            close();
        }
    }

    private void close() {
        sc.close();
        com.say(SEE_YOU);
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
                return new TournamentHeadsUpRule(list);
        }
        return null;
    }


    private void choiceGame() {
        com.say(GAME);
        gameType = sc.nextLine();
        while (!gameType.matches(REGEX_GAME_CHOICE)) {
            com.say(GAME);
            gameType = sc.nextLine();
        }
    }

    private void choicePlayer() {
        if (Integer.parseInt(gameType) > 3) {
            com.say(PLAYER_PAIRS);
            playersCount = sc.nextLine();
            while (!playersCount.matches(REGEX_PLAYERS_PP_COUNT_CHOICE)) {
                com.say(PLAYER_PAIRS);
                playersCount = sc.nextLine();
            }
        } else {
            com.say(PLAYERS);
            playersCount = sc.nextLine();
            while (!playersCount.matches(REGEX_PLAYERS_COUNT_CHOICE)) {
                com.say(PLAYERS);
                playersCount = sc.nextLine();
            }
        }
    }

    private void init() {
        com.say(HELLO);
        sc.nextLine();
        playerName = sc.nextLine();
        while (playerName.equals("") || playerName.length() > 10) {
            com.say(NAME);
            playerName = sc.nextLine();
        }
    }
}
