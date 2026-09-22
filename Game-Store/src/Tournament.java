
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tournament {
    private String name;
    private int maxPlayers;
    private List<Player> players = new ArrayList<>();
    private Player winner;

    public Tournament(String name, int maxPlayers) {
        this.name = name;
        this.maxPlayers = maxPlayers;
    }

    public String getName() {
        return name;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player getWinner() {
        return winner;
    }

    public void registerPlayer(Player player) {
        if (players.size() >= maxPlayers) {
            throw new Tournamentfullexception();
        }

        for (Player p : players) {
            if (p.equals(player)) {
                throw new Duplicateregistrationexception(player.getName());
            }
        }

        players.add(player);
    }

    public void startTournament() {
        if (players.size() < 2) {
            throw new NotEnoughPlayersException();
        }

        System.out.println("Starting tournament: " + name);

        List<Player> remaining = new ArrayList<>(players);
        Random random = new Random();

        while (remaining.size() > 1) {
            List<Player> nextRound = new ArrayList<>();

            for (int i = 0; i < remaining.size() - 1; i += 2) {
                Player player1 = remaining.get(i);
                Player player2 = remaining.get(i + 1);

                Player matchWinner;
                if (random.nextBoolean()) {
                    matchWinner = player1;
                } else {
                    matchWinner = player2;
                }

                System.out.println(player1.getName() + " vs " + player2.getName() + " -> Winner: " + matchWinner.getName());
                nextRound.add(matchWinner);
            }

            if (remaining.size() % 2 != 0) {
                Player byePlayer = remaining.get(remaining.size() - 1);
                System.out.println(byePlayer.getName() + " gets a bye this round");
                nextRound.add(byePlayer);
            }

            remaining = nextRound;
        }

        winner = remaining.get(0);
        System.out.println("Tournament winner: " + winner.getName());
    }
}
