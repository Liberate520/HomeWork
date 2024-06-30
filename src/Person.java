import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private String gender;
    private List<Person> parents;
    private List<Person> children;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    // Получение имени человека
    public String getName() {
        return name;
    }

    // Получение возраста человека
    public int getAge() {
        return age;
    }

    // Получение пола человека
    public String getGender() {
        return gender;
    }

    // Получение списка родителей
    public List<Person> getParents() {
        return parents;
    }

    // Получение списка детей
    public List<Person> getChildren() {
        return children;
    }

    // Добавление родителя
    public void addParent(Person parent) {
        this.parents.add(parent);
    }

    // Добавление ребенка
    public void addChild(Person child) {
        this.children.add(child);
        child.addParent(this);
    }

    @Override
    public String toString() {
        return "Имя='" + name + '\'' + ", Возраст=" + age + ", Пол='" + gender + '\'';
    }
}