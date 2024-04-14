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

    public String getChildrenNames() {
        if (children.isEmpty()) {
            return "Нет";
        }
        StringBuilder builder = new StringBuilder();
        for (Person child : children) {
            builder.append(child.getName()).append(", ");
        }
        return builder.substring(0, builder.length() - 2);
    }

    public int getAge() {
        return age;
    }

    public Person getSpouse() {
        return spouse;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
        // Установите супруга/супругу для spouse, чтобы создать двунаправленную связь
        if (spouse != null && spouse.getSpouse() != this) {
            spouse.setSpouse(this);
        }
    }

    public void setMother(Person mother) {
        this.mother = mother;
        // Добавьте этого человека в список детей матери
        if (mother != null) {
            mother.addChild(this);
        }
    }

    public void setFather(Person father) {
        this.father = father;
        // Добавьте этого человека в список детей отца
        if (father != null) {
            father.addChild(this);
        }
    }

    public void addChild(Person child) {
        // Добавьте ребенка в список детей этого человека
        if (!children.contains(child)) {
            children.add(child);
            // Установите этого человека в качестве родителя для ребенка, если родитель не установлен
            if (child.getMother() == null && child.getFather() == null) {
                if ("Female".equals(gender)) {
                    child.setMother(this);
                } else {
                    child.setFather(this);
                }
            }

        }
    }

    public <U> U getBirthDate() {
        return null;
    }
}