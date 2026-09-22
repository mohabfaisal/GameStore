import java.util.List;

public interface Search {
    List<Game> searchByName(String name);
    List<Game> searchByGenre(Genre genre);
}

