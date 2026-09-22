public class Item {
    private Game game;
    private int quantity;

    public Item(Game game, int quantity) {
        this.game = game;
        this.quantity = quantity;
    }

    public Game getGame() {
        return game;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getSubtotal() {
        return game.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return game.getName() + " x" + quantity + " = " + getSubtotal();
    }
}