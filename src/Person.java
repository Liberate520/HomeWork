import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
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

    public String getName() {
        return name;
    }

    public String getBirthDate() {
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
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
        if (this.gender == Gender.MALE) {
            child.setFather(this);
        } else if (this.gender == Gender.FEMALE) {
            child.setMother(this);
        }
    }

    @Override
    public String toString() {
        String fatherName = (father != null) ? father.getName() : "no";
        String motherName = (mother != null) ? mother.getName() : "no";
        StringBuilder childrenNames = new StringBuilder();
        if (children.isEmpty()) {
            childrenNames.append("no");
        } else {
            for (Person child : children) {
                childrenNames.append(child.getName()).append(" ");
            }
        }

        return "Имя: " + name + ", Дата рождения: " + birthDate + ", Пол: " + gender + 
               ", Отец: " + fatherName + ", Мать: " + motherName + ", Дети: " + childrenNames;
    }
}
