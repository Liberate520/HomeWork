package Human;

import java.io.Serializable;

public class Gender implements Serializable {
    public static final Gender MALE = new Gender("MALE");
    public static final Gender FEMALE = new Gender("FEMALE");

    private final String name;

    private Gender(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
