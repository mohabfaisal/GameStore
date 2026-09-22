public class PcGames  extends Game{
    private PCSYSTEMS PcType ;

    public PcGames(int id, String name, float price, float rating, String description, Genre genre, PCSYSTEMS pcType) {
        super(id, name, price, rating, description, genre);
        this.PcType=pcType;
    }

    public PCSYSTEMS getPcType() {
        return PcType;
    }

    public void setPcType(PCSYSTEMS pcType) {
        PcType = pcType;
    }
    @Override
    public String GameInformation() {
       return "Game Name : " + getName()+ "PC System  : "+ PcType +" Price :"+getPrice() ;
    }


}
