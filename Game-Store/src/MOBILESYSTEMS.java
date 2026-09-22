public enum MOBILESYSTEMS {
    ANDROID(" Android devices"),
    IOS(" Apple iOS devices");

    private final String description;

    MOBILESYSTEMS(String description) {
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
