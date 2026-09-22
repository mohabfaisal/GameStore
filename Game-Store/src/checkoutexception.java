public class checkoutexception extends OrderException {
    public checkoutexception() {
        super("Cannot checkout an empty order");
    }
}
