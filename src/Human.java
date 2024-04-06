import java.time.LocalDate;
import java.util.List;

public class Human {
    public Human(String name,  String gender, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
    }
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private String gender;
    private Human father, mother;
    private List<Human> children;

    public void SetDateOfBirth(int year, int month, int day) {
        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    public void SetDateOfDeath(int year, int month, int day) {
        this.dateOfDeath = LocalDate.of(year, month, day);
    }

    public String getChildren() {
        for (Human child: children) {
            return child.getName();
        }
        return " ";
    }
    public String getName () {
        return name;
    }
    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        if (dateOfDeath == null) {
            return now.getYear() - dateOfBirth.getYear();
        } else {
            return dateOfDeath.getYear() - dateOfBirth.getYear();
        }
    }
    
    public void addChild(List<Human> children, Human child) {
        if (children.contains(child)) {
            children.remove(child);
        }
        children.add(child);
    }

    public String getInfo() {
        return "Human [name=" + name + ", dateOfBirth=" + dateOfBirth + ", dateOfDeath=" + dateOfDeath + ", age=" + getAge() + ", gender="
                + gender + ", father=" + father.getName() + ", mother=" + mother.getName() + ", children=" + getChildren() + "]";
    }
}