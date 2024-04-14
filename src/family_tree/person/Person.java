package family_tree.person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private int id;
    private String name;
    private String gender;
    private int age;
    private Person spouse;
    private Person mother;
    private Person father;
    private List<Person> children;

    public Person(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.children = new ArrayList<>(); // Инициализация списка детей
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    // Метод для вывода информации о человеке
    public void displayInfo() {
        System.out.println("id: " + id +
                ", имя: " + name +
                ", пол: " + gender +
                ", возраст: " + age +
                ", супруг(а): " + (spouse != null ? spouse.getName() : "Нет") +
                ", мать: " + (mother != null ? mother.getName() : "Нет") +
                ", отец: " + (father != null ? father.getName() : "Нет") +
                ", дети: " + (children.isEmpty() ? "Нет" : getChildrenNames()));
    }

    // Метод для получения имен детей в виде строки
    private String getChildrenNames() {
        StringBuilder builder = new StringBuilder();
        for (Person child : children) {
            builder.append(child.getName()).append(", ");
        }
        return builder.substring(0, builder.length() - 2);
    }

    @Override
public String toString() {
    return "Имя: " + name +
            ", Пол: " + gender +
            ", Возраст: " + age +
            ", Супруг(а): " + (spouse != null ? spouse.getName() : "Нет") +
            ", Мать: " + (mother != null ? mother.getName() : "Нет") +
            ", Отец: " + (father != null ? father.getName() : "Нет") +
            ", Дети: " + (children.isEmpty() ? "Нет" : getChildrenNames());
}
}
