public class Duplicateregistrationexception extends Tournamentexception {
    public Duplicateregistrationexception(String playerName) {
        super("Player " + playerName + " is already registered in this tournament");
    }
}

