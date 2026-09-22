public enum PCSYSTEMS {
    WINDOWS(" Windows : Microsoft OS"),
    MAC(" MAC :  Apple OS"),
    LINUX(" Linux : open Source OS");

    private final String description;

    PCSYSTEMS(String description) {
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

