import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Person> children;

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        return "Person [Name: " + name + ", Age: " + age + ", Gender: " + gender + "]";
    }
}
