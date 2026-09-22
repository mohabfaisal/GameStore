public class RegularPlayer extends Player implements Discount{
    private static final float discountRate = 0.05f;

    public RegularPlayer(int id ,String name, String email) {
        super(id ,name, email);
    }
    @Override
    public float calcDiscont(float total) {
        return  total*discountRate;
    }
}
