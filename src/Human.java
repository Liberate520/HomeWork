import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private List<Human> children;

    public Human(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public Gender getGender() {
        return gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }
}