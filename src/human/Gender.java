package human;

public enum Gender {

    Male ("мужчина"),
    Female ("женщина");

    private String gender;


    Gender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return gender;
    }
}
