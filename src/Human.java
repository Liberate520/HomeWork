import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Human implements Serializable, Comparable<Human> {

    private String name;
    private String gender;
    private Integer age;
    private Human father;
    private Human mother;
    private List<Human> children = new ArrayList<>();


    public Human(String name, String gender, Integer age, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();

    }

    public Integer getAge() {
        return age;
    }

    public Human() {
        this.name = null;
        this.gender = null;
        this.age = null;
        this.father = null;
        this.mother = null;


    }

    public Human(String name, String gender, Integer age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.father = null;
        this.mother = null;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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


    public String getChildren() {
        String res = "";
        for (Human child : children) {
            res += child + "\n";
        }
        return "Дети этого человека\n " + res;
    }

    @Override
    public String toString() {
        return "Имя= " + name +
                ", Пол = " + gender +
                " Возраст = " + age;
    }

    public String printParents() {
        if (father == null || mother == null) {
            return "Нет данных о родителей данного человека";
        } else {
            return "Родители данного человека\n" +
                    "Отец = " + father + "," +
                    "Мать = " + mother;
        }
    }

    public List<Human> getChildList() {
        return children;
    }


    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.getName());
    }
}



