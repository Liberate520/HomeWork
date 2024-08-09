import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Single Responsibility Principle (SRP) - Принцип единственной ответственности
// Класс Person должен отвечать только за данные и поведение конкретного человека, а не за управление списком детей.

class Person<T extends Person<T>> implements GenTreeService<T> {
    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private T father;
    private T mother;
    private List<T> children;

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

    public T getFather() {
        return father;
    }

    public void setFather(T father) {
        this.father = father;
        if (father != null && father instanceof T) {
            ((Person) father).addChild(this);
        }
    }

    public T getMother() {
        return mother;
    }

    @Override
    public List<T> children() {
        return children;
    }

    public void setMother(T mother) {
        this.mother = mother;
        if (mother != null && mother instanceof T) {
            ((Person) mother).addChild(this);
        }
    }

    public List<T> getChildren() {
        return children;
    }

    private void addChild(T child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Дата рождения: " + birthDate + ", Пол: " + gender;
    }
}