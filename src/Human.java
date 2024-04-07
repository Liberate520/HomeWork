import java.time.LocalDate;

public class Human {

    private String name;
    private LocalDate dob;
    private LocalDate dod;
    private Gender gender;
    private Human mother;
    private Human father;

    public Human(String name, LocalDate dob, LocalDate dod, Gender gender, Human mother, Human father) {
        this.name = name;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, Gender gender, LocalDate dob) {
        this(name, dob, null, gender, null, null);
    }

    public String getName() {
        return this.name;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public Gender getGender() {
        return this.gender;
    }

    public LocalDate getDod() {
        if (this.dod == null) {
            return LocalDate.now();
        }
        return dod;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}