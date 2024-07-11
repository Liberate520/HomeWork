import java.util.ArrayList;
import java.util.List;

public class Person {
    /** Имя */
    private String name;

    /** Пол */
    private String gender;

    /** Возраст */
    private int age;

    /** Отец */
    private Person father;

    /** Мать */
    private Person mother;

    /** Дети */
    private List<Person> children;

    /**
     * Создание Person с учетом родителей
     *
     * @param name Имя человека
     * @param gender Пол человека
     * @param age Возраст человека
     * @param father Отец человека
     * @param mother Мать человека
     */
    public Person(String name, String gender, int age, Person father, Person mother) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    /**
     * Создание Person без учета родителей
     *
     * @param name Имя человека
     * @param gender Пол человека
     * @param age Возраст человека
     */
    public Person(String name, String gender, int age) {
        this(name, gender, age, null, null);
    }

    /** Получить имя */
    public String getName() {
        return name;
    }

    /** Получить пол */
    public String getGender() {
        return gender;
    }

    /** Получить возраст */
    public int getAge() {
        return age;
    }

    /** Получить инфу об отце */
    public Person getFather() {
        return father;
    }

    /** Получить инфу о матери */
    public Person getMother() {
        return mother;
    }

    /** Получить инфу о детях человека */
    public List<Person> getChildren() {
        return children;
    }

    // Setters
    /** Установить мать для человека */
    public void setMother(Person mother) {
        this.mother = mother;
    }

    /** Установить отца для человека */
    public void setFather(Person father) {
        this.father = father;
    }

    // Add
    /** Добавить ребенка */
    public void addChild(Person child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        return "Name: " + name + "; Gender: " + gender +
                "; Age: " + age + "; Father: " + (father != null ? father.getName() : "Unknown") +
                "; Mother: " + (mother != null ? mother.getName() : "Unknown");
    }
}
