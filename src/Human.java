import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String firstName;
    private String secondName;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> children = new ArrayList<>();

    public Human(String firstName, String secondName, LocalDate birthDate, Gender gender) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.mother = new Human();
        this.father = new Human();
    }

public Human() {}

    public void setMother(Human mother) {
        this.mother = mother;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public void setChildren(Human child) {
        children.add(child);
    }
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getSecondName() {
        return secondName;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
//    public LocalDate getDeathDate() {
//        return deathDate;
//    }
    public String getDeathDate() {
        String string;
        if(deathDate == null)
            string = "Is alive";
        else string = deathDate.toString();
        return string;
    }
    public Gender getGender() {
        return gender;
    }
    public String getMother() {
        String string;
        if (mother.firstName == null)
            string = "No data found";
        else string = mother.toString();
       return string;
    }
    public String getFather() {
        String string;
        if (father.firstName == null)
            string = "No data found";
        else string = father.toString();
        return string;
    }
    public String getChildren() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human child : children) {
            stringBuilder.append(child.toString());
            stringBuilder.append("\n");
        }
        if (stringBuilder.isEmpty()) {
            stringBuilder.append("No children found");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return firstName + " " + secondName +
                ", birth date - " + birthDate +
                ", " + gender;
    }
}
