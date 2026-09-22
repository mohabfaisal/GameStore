import java.util.ArrayList;
import java.util.List;

public class Gamestore implements Search, Sort {
    private String storeName;
    private List<Game> games = new ArrayList<>();

    public Gamestore(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void addGame(Game game) {
        games.add(game);
    }

    public void removeGame(Game game) {
        games.remove(game);
    }

    public List<Game> getGames() {
        return games;
    }

    @Override
    public List<Game> searchByName(String name) {
        List<Game> result = new ArrayList<>();
        for (Game g : games) {
            if (g.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(g);
            }
        }
        return result;
    }

    @Override
    public List<Game> searchByGenre(Genre genre) {
        List<Game> result = new ArrayList<>();
        for (Game g : games) {
            if (g.getGener() == genre) {
                result.add(g);
            }
        }
        return result;
    }

    @Override
    public List<Game> sortByPrice() {
        List<Game> sorted = new ArrayList<>(games);
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = 0; j < sorted.size() - 1 - i; j++) {
                if (sorted.get(j).getPrice() > sorted.get(j + 1).getPrice()) {
                    Game temp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, temp);
                }
            }
        }
        return sorted;
    }

    @Override
    public List<Game> sortByRating() {
        List<Game> sorted = new ArrayList<>(games);
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = 0; j < sorted.size() - 1 - i; j++) {
                if (sorted.get(j).getRating() < sorted.get(j + 1).getRating()) {
                    Game temp = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, temp);
                }
            }
        }
        return sorted;
    }
}
