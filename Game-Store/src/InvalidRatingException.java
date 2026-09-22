public class InvalidRatingException extends GameException {
    public InvalidRatingException(float rating) {
        super("Invalid rating: " + rating + ". Rating must be between 0 and 5");
    }
}
