package about_abstract.Iterator;

public abstract class Ingredients {
    String breand;

    public Ingredients(String breand) {
        this.breand = breand;
    }

    @Override
    public String toString() {
        return breand;
    }
}
