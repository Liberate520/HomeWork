package Human;

public enum Gender {
    Male("мужской"),
    Famale("женский");

    private final String displayName;

    Gender(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
