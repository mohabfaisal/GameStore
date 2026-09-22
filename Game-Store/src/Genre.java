public enum Genre {
      ACTION("Fast Pace - High Intensity")
    , SPORTS("Real World Sports")
    , STRATEGY("Planning and Tactics");

    private final String description;

    Genre(String description) {
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
