import java.util.List;

public class Human {
    String name;
    Gender gender;
    String birthDate, deathDate;
    List<Human> parents;
    List<Human> children;
    Integer id;

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Integer getId() {
        return id;
    }

    public Human(String name, Gender gender, String birthDate, String deathDate, List<Human> parents, List<Human> children, Integer id) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.id = id;
    }

    public Human() {
    }


    @Override
    public String toString() {
        return "id: " + id + ", " + "name: " + name + ", " + "gender: " + gender + ", " +
                "birthDate: " + birthDate + ", " + "deathDate: " + deathDate + " |";
    }
}
