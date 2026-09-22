public class NotEnoughPlayersException extends Tournamentexception{
    public NotEnoughPlayersException() {
        super("Not enough players to start the tournament");
    }
}
