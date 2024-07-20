import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {

    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private Person father;
    private Person mother;
    private List<Person> children;

    public Person(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
        if (father != null) {
            father.addChild(this);
        }
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
        if (mother != null) {
            mother.addChild(this);
        }
    }

    public List<Person> getChildren() {
        return children;
    }

    private void addChild(Person child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Дата рождения: " + birthDate + ", Пол: " + gender;
    }
}