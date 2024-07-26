import java.time.LocalDate;
import java.util.List;

public class Human {
    protected String name;
    private Gender gender;
    private LocalDate birthDate, deathDate;
    protected List<Human> parents;
    protected List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, List<Human> parents, List<Human> children) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.parents = parents;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }
}
