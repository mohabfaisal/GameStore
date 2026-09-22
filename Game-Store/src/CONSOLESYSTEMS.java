public enum CONSOLESYSTEMS {
    PLAYSTATION(" PlayStation console"),
    XBOX("Xbox console");

    private final String description;

    CONSOLESYSTEMS(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name() + " - " + description;
    }
}
