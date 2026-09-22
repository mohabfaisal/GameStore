public class MobileGames extends Game{
    private MOBILESYSTEMS MobileType ;

    public MobileGames(int id, String name, float price, float rating, String description, Genre genre, MOBILESYSTEMS mobileType) {
        super(id, name, price, rating, description, genre);
     this.MobileType=mobileType;
    }

    public MOBILESYSTEMS getMobileType() {
        return MobileType;
    }

    public void setMobileType(MOBILESYSTEMS mobileType) {
        MobileType = mobileType;
    }

    @Override
    public String GameInformation() {
        return "Game Name : " + getName()+ "Mobile System  : "+ MobileType +" Price :"+getPrice();
    }
}
