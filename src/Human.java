import java.time.LocalDate;
import java.util.List;

public class Human {
    String name;
    LocalDate dob, dod;
    Gender gender;
    List<Human> children;
    String mother, father;

    public Human(String name, LocalDate dob, LocalDate dod, Gender gender) {
        this.name = name;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;

    }

    public Human(String name, LocalDate dob, LocalDate dod, Gender gender, List<Human> children, String mother, String father) {
        this.name = name;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;
        this.children = children;
        this.mother = mother;
        this.father = father;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDod() {
        return dod;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    @Override
    public String toString() {
        return "\nHuman{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                ", dod=" + dod +
                ", gender=" + gender +
                ",\n children=" + children +
               ", \n mather=" + mother +
                ", father=" + father +
                '}';
    }
}
