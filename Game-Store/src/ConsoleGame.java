public class ConsoleGame extends Game{
    private CONSOLESYSTEMS ConsoleType ;

    public ConsoleGame(int id, String name, float price, float rating, String description, Genre genre, CONSOLESYSTEMS consoleType) {
        super(id, name, price, rating, description, genre);
        ConsoleType = consoleType;
    }

    public CONSOLESYSTEMS getConsoleType() {
        return ConsoleType;
    }

    public void setConsoleType(CONSOLESYSTEMS consoleType) {
        ConsoleType = consoleType;
    }
    @Override
    public String GameInformation() {
        return "Game Name : " + getName()+ " Console System  : "+ ConsoleType +" Price :"+getPrice();
    }

}
