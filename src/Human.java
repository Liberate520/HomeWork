import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Human {
    private String id;
    private String name;
    private String surname;
    private int age;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human father;
    private Human mother;
    private List<Human> children;

    public enum Gender {
        Male, Female;
    }

    public Human(String id, String name, String surname, int age, Gender gender, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
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

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        children.add(child);
    }

    @Override
    public String toString() {
        String childrenNames = children.stream()
                .map(Human::getName)
                .collect(Collectors.joining(", "));

        return "id: " + id +
                ", Имя: " + name +
                ", Фамилия: " + surname +
                ", Возраст: " + age +
                ", Отец: " + (father != null ? father.getName() : "Неизвестен") +
                ", Мать: " + (mother != null ? mother.getName() : "Неизвестна") +
                ", Дети: " + (childrenNames.isEmpty() ? "Нет" : childrenNames);
    }
}
