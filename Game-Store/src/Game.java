public  abstract class Game {
    private int  id ;
    private String name ;
    private float price ;
    private float rating ;
    private String Description ;
    private Genre genre;

    public Game(int id, String name, float price, float rating, String description , Genre genre) {
       validaterate(rating);
       validateprice(price);
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
        Description = description;
        this.genre = genre;
    }

    public  void validaterate(float rating){
        if (rating <0 && rating> 5){
            throw  new InvalidRatingException(rating);
        }

    }
    public void validateprice (float price){
        if (price <= 0){
            throw new InvalidPriceException(price);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        validateprice(price);
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
     validaterate(rating);
        this.rating = rating;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Genre getGener() {
        return genre;
    }

    public void setGener(Genre genre) {
        this.genre = genre;
    }

    public abstract String GameInformation ();
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Game)) return false;
        Game other = (Game) obj;
        return this.id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", Description='" + Description + '\'' +
                ", gener=" + genre +
                '}';
    }
}
