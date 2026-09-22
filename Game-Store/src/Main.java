import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Gamestore store = new Gamestore("My Game Store");
    static List<Player> players = new ArrayList<>();
    static List<Order> orders = new ArrayList<>();
    static Tournament tournament;
    static int nextPlayerId = 1;
    static int nextGameId = 1;

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        addGame();
                        break;
                    case "2":
                        removeGame();
                        break;
                    case "3":
                        displayAllGames();
                        break;
                    case "4":
                        searchGameByName();
                        break;
                    case "5":
                        searchGameByGenre();
                        break;
                    case "6":
                        sortGamesByPrice();
                        break;
                    case "7":
                        sortGamesByRating();
                        break;
                    case "8":
                        registerPlayer();
                        break;
                    case "9":
                        createOrder();
                        break;
                    case "10":
                        addGameToOrder();
                        break;
                    case "11":
                        removeGameFromOrder();
                        break;
                    case "12":
                        checkoutOrder();
                        break;
                    case "13":
                        createTournament();
                        break;
                    case "14":
                        registerPlayerInTournament();
                        break;
                    case "15":
                        startTournament();
                        break;
                    case "0":
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice, try again.");
                }
            } catch (storeexception e) {
                System.out.println("Error: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number entered.");
            }
        }
    }

    static void printMenu() {
        System.out.println();
        System.out.println("===== Game Store Menu =====");
        System.out.println("1. Add Game");
        System.out.println("2. Remove Game");
        System.out.println("3. Display All Games");
        System.out.println("4. Search Game By Name");
        System.out.println("5. Search Game By Genre");
        System.out.println("6. Sort Games By Price");
        System.out.println("7. Sort Games By Rating");
        System.out.println("8. Register Player");
        System.out.println("9. Create Order");
        System.out.println("10. Add Game To Order");
        System.out.println("11. Remove Game From Order");
        System.out.println("12. Checkout Order");
        System.out.println("13. Create Tournament");
        System.out.println("14. Register Player In Tournament");
        System.out.println("15. Start Tournament");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    static void addGame() {
        System.out.print("Enter game type (1-PC, 2-Console, 3-Mobile): ");
        String type = scanner.nextLine();

        System.out.print("Enter game name: ");
        String name = scanner.nextLine();

        System.out.print("Enter price: ");
        float price = Float.parseFloat(scanner.nextLine());

        System.out.print("Enter rating (0-5): ");
        float rating = Float.parseFloat(scanner.nextLine());

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        Genre genre = chooseGenre();

        Game game = null;

        if (type.equals("1")) {
            PCSYSTEMS system = choosePcSystem();
            game = new PcGames(nextGameId, name, price, rating, description, genre, system);
        } else if (type.equals("2")) {
            CONSOLESYSTEMS system = chooseConsoleSystem();
            game = new ConsoleGame(nextGameId, name, price, rating, description, genre, system);
        } else if (type.equals("3")) {
            MOBILESYSTEMS system = chooseMobileSystem();
            game = new MobileGames(nextGameId, name, price, rating, description, genre, system);
        } else {
            System.out.println("Invalid game type.");
            return;
        }

        store.addGame(game);
        nextGameId++;
        System.out.println("Game added successfully.");
    }

    static Genre chooseGenre() {
        System.out.println("Choose genre:");
        Genre[] genres = Genre.values();
        for (int i = 0; i < genres.length; i++) {
            System.out.println((i + 1) + ". " + genres[i]);
        }
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        return genres[index];
    }

    static PCSYSTEMS choosePcSystem() {
        System.out.println("Choose PC system:");
        PCSYSTEMS[] systems = PCSYSTEMS.values();
        for (int i = 0; i < systems.length; i++) {
            System.out.println((i + 1) + ". " + systems[i]);
        }
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        return systems[index];
    }

    static CONSOLESYSTEMS chooseConsoleSystem() {
        System.out.println("Choose console system:");
        CONSOLESYSTEMS[] systems = CONSOLESYSTEMS.values();
        for (int i = 0; i < systems.length; i++) {
            System.out.println((i + 1) + ". " + systems[i]);
        }
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        return systems[index];
    }

    static MOBILESYSTEMS chooseMobileSystem() {
        System.out.println("Choose mobile system:");
        MOBILESYSTEMS[] systems = MOBILESYSTEMS.values();
        for (int i = 0; i < systems.length; i++) {
            System.out.println((i + 1) + ". " + systems[i]);
        }
        int index = Integer.parseInt(scanner.nextLine()) - 1;
        return systems[index];
    }

    static void removeGame() {
        System.out.print("Enter game id to remove: ");
        int id = Integer.parseInt(scanner.nextLine());

        Game found = findGameById(id);
        if (found == null) {
            System.out.println("Game not found.");
            return;
        }

        store.removeGame(found);
        System.out.println("Game removed successfully.");
    }

    static Game findGameById(int id) {
        for (Game g : store.getGames()) {
            if (g.getId() == id) {
                return g;
            }
        }
        return null;
    }

    static void displayAllGames() {
        if (store.getGames().isEmpty()) {
            System.out.println("No games in the store.");
            return;
        }
        for (Game g : store.getGames()) {
            System.out.println(g.GameInformation());
        }
    }

    static void searchGameByName() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine();
        List<Game> result = store.searchByName(name);
        printGameList(result);
    }

    static void searchGameByGenre() {
        Genre genre = chooseGenre();
        List<Game> result = store.searchByGenre(genre);
        printGameList(result);
    }

    static void sortGamesByPrice() {
        printGameList(store.sortByPrice());
    }

    static void sortGamesByRating() {
        printGameList(store.sortByRating());
    }

    static void printGameList(List<Game> games) {
        if (games.isEmpty()) {
            System.out.println("No games found.");
            return;
        }
        for (Game g : games) {
            System.out.println(g.GameInformation());
        }
    }

    static void registerPlayer() {
        System.out.print("Enter player type (1-Regular, 2-VIP): ");
        String type = scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Player player;
        if (type.equals("1")) {
            player = new RegularPlayer(nextPlayerId, name, email);
        } else if (type.equals("2")) {
            player = new VipPlayer(nextPlayerId, name, email);
        } else {
            System.out.println("Invalid player type.");
            return;
        }

        players.add(player);
        nextPlayerId++;
        System.out.println("Player registered successfully.");
    }

    static Player findPlayerById(int id) {
        for (Player p : players) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    static void createOrder() {
        System.out.print("Enter player id: ");
        int id = Integer.parseInt(scanner.nextLine());

        Player player = findPlayerById(id);
        if (player == null) {
            System.out.println("Player not found.");
            return;
        }

        Order order = new Order(player);
        orders.add(order);
        System.out.println("Order created with id " + order.getOrderId());
    }

    static Order findOrderById(int id) {
        for (Order o : orders) {
            if (o.getOrderId() == id) {
                return o;
            }
        }
        return null;
    }

    static void addGameToOrder() {
        System.out.print("Enter order id: ");
        int orderId = Integer.parseInt(scanner.nextLine());
        Order order = findOrderById(orderId);
        if (order == null) {
            System.out.println("Order not found.");
            return;
        }

        System.out.print("Enter game id: ");
        int gameId = Integer.parseInt(scanner.nextLine());
        Game game = findGameById(gameId);
        if (game == null) {
            System.out.println("Game not found.");
            return;
        }

        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        order.addGame(game, quantity);
        System.out.println("Game added to order.");
    }

    static void removeGameFromOrder() {
        System.out.print("Enter order id: ");
        int orderId = Integer.parseInt(scanner.nextLine());
        Order order = findOrderById(orderId);
        if (order == null) {
            System.out.println("Order not found.");
            return;
        }

        System.out.print("Enter game id: ");
        int gameId = Integer.parseInt(scanner.nextLine());
        Game game = findGameById(gameId);
        if (game == null) {
            System.out.println("Game not found.");
            return;
        }

        order.removeGame(game);
        System.out.println("Game removed from order.");
    }

    static void checkoutOrder() {
        System.out.print("Enter order id: ");
        int orderId = Integer.parseInt(scanner.nextLine());
        Order order = findOrderById(orderId);
        if (order == null) {
            System.out.println("Order not found.");
            return;
        }

        order.checkout();
    }

    static void createTournament() {
        System.out.print("Enter tournament name: ");
        String name = scanner.nextLine();

        System.out.print("Enter max players: ");
        int max = Integer.parseInt(scanner.nextLine());

        tournament = new Tournament(name, max);
        System.out.println("Tournament created.");
    }

    static void registerPlayerInTournament() {
        if (tournament == null) {
            System.out.println("No tournament created yet.");
            return;
        }

        System.out.print("Enter player id: ");
        int id = Integer.parseInt(scanner.nextLine());
        Player player = findPlayerById(id);
        if (player == null) {
            System.out.println("Player not found.");
            return;
        }

        tournament.registerPlayer(player);
        System.out.println("Player registered in tournament.");
    }

    static void startTournament() {
        if (tournament == null) {
            System.out.println("No tournament created yet.");
            return;
        }

        tournament.startTournament();
    }
}
