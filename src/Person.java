import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private int birthYear;
    private Gender gender;
    private Person father;
    private Person mother;
    private List<Person> children;

    public Person(String name, int birthYear, Gender gender) {
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
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
        return "Имя: " + name + ", Год рождения: " + birthYear + " Пол: " + gender;
    }
}