public class Gender {
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