import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String birthDate;
    private Gender gender;
    private Person father;
    private Person mother;
    private List<Person> children;

    public Person(String name, String birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public void addChild(Person child) {
        children.add(child);
        if (this.gender == Gender.MALE) {
            child.setFather(this);
        } else if (this.gender == Gender.FEMALE) {
            child.setMother(this);
        }
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getFatherName() {
        return father != null ? father.getName() : "no";
    }

    public String getMotherName() {
        return mother != null ? mother.getName() : "no";
    }

    public String getChildrenNames() {
        if (children.isEmpty()) {
            return "no";
        }
        StringBuilder childrenNames = new StringBuilder();
        for (Person child : children) {
            childrenNames.append(child.getName()).append(", ");
        }
        return childrenNames.substring(0, childrenNames.length() - 2); 
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Дата рождения: " + birthDate + ", Пол: " + (gender == Gender.MALE ? "Мужской" : "Женский") + 
               ", Папа: " + getFatherName() + ", Мама: " + getMotherName() + ", Дети: " + getChildrenNames();
    }
}
