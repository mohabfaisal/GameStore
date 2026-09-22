import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int nextId = 1;

    private final int orderId;
    private Player player;
    private List<Item> items = new ArrayList<>();

    public Order(Player player) {
        this.orderId = nextId++;
        this.player = player;
    }

    public int getOrderId() {
        return orderId;
    }

    public Player getPlayer() {
        return player;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addGame(Game game, int quantity) {
        for (Item item : items) {
            if (item.getGame().equals(game)) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new Item(game, quantity));
    }

    public void removeGame(Game game) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getGame().equals(game)) {
                items.remove(i);
                return;
            }
        }
    }

    public float calculateTotal() {
        float total = 0;
        for (Item item : items) {
            total += item.getSubtotal();
        }

        if (player instanceof Discount) {
            Discount discountPlayer = (Discount) player;
            float discount = discountPlayer.calcDiscont(total);
            total-= discount;
        }

        return total;
    }

    public void checkout() {
        boolean checkout=items.isEmpty();
        if (checkout) {
            throw new checkoutexception();
        }
        System.out.println("Order #" + orderId + " total for " + player.getName() + ": " + calculateTotal());
    }
}
