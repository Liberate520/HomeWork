import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private List<Human> children;
    private List<Human> parents;

    public Human(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public Human(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this(name, birthDate, gender);
        this.deathDate = deathDate;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        LocalDate endDate = (deathDate != null) ? deathDate : LocalDate.now();
        return Period.between(birthDate, endDate).getYears();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        this.children.add(child);
        child.addParent(this);
    }

    public List<Human> getParents() {
        return parents;
    }

    public void addParent(Human parent) {
        this.parents.add(parent);
    }

    public boolean isAlive() {
        return deathDate == null;
    }
}