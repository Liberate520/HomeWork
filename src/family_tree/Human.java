package family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;      // Добавляю имя, дату рождения и смерти, список людей, папу, маму и гендер
    private LocalDate birthDate, deathDate;
    private List<String> children;
    private Human father, mother;
    private Gender gender;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;    // Делаю метод класса с аргументами, которые вводятся в файле Main.java
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null);
    }
    // то же самое, что и сверху, но с меньшим количеством аргументов
    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        this(name, gender, birthDate, null, father, mother);
    }

    public void addChild(String string) {
        if (children == null) {
            children = null; // Метод добавления людей в список детей
        } else {
            children.add(name);
        }
    }
    // Далее методы добавление имени, гендер и так далее, а также их получение
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    @Override
    public String toString() { // Вывод через метод toString
        return "Name: " + name + "\n" + "Gender: " + gender + " | " + "Birth Day: " + birthDate + " (Death Day: " + deathDate + ")" + "\n" + "Father: \n" + father + "\n" + "Mother: \n" + mother + "\n" + "Children: \n" + children + "\n";
    }

}
