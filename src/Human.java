import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Human {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private final String gender;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String name, LocalDate birthDate, String gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public Human(String name, LocalDate birthDate, LocalDate deathDate, String gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public String getGender() {
        return gender;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        this.children.add(child);
        if (this.gender.equalsIgnoreCase("female")) {
            child.setMother(this);
        } else if (this.gender.equalsIgnoreCase("male")) {
            child.setFather(this);
        }
    }

    @Override
    public String toString() {
        return name + " (" + birthDate + " - " + (deathDate != null ? deathDate : "настоящее время") + ", " + gender + ")";
    }
}