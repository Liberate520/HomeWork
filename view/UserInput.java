package view;

public class UserInput {
    private String name;
    private String birthDate;
    private String gender;
    private Integer fatherId;
    private Integer motherId;

    public UserInput(String name, String birthDate, String gender, Integer fatherId, Integer motherId) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.fatherId = fatherId;
        this.motherId = motherId;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public Integer getMotherId() {
        return motherId;
    }
}
