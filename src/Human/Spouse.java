package Human;

public enum Spouse {

    SpouseWomen("Супруга"),
    SpouseMen("Супруг");

    private String spouse;

    Spouse(String spouse) {
        this.spouse = spouse;
    }

    public String getSpouse() {
        return spouse;
    }
}
