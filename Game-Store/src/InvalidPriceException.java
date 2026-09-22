public class InvalidPriceException extends GameException {
    public InvalidPriceException(float price) {
        super("Invalid price: " + price + ". Price cannot be negative OR = 0");
    }
}