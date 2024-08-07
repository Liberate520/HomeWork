package Family_Tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person implements Serializable {
    public static final int MALE = 0;
    public static final int FEMALE = 1;

    private String name;
    private int gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Person> parents;
    private List<Person> children;

    public Person(String firstName, String lastName, int gender, LocalDate birthDate) {
        this.name = firstName + " " + lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void addParent(Person parent) {
        this.parents.add(parent);
        parent.children.add(this);
    }

    public void addChild(Person child) {
        this.children.add(child);
        child.parents.add(this);
    }

    public List<Person> getChildren() {
        return this.children;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        if (deathDate != null) {
            return Period.between(birthDate, deathDate).getYears();
        } else {
            return Period.between(birthDate, LocalDate.now()).getYears();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ").append(name).append(", ");
        sb.append("Пол: ").append(gender == MALE ? "Мужской" : "Женский").append(", ");
        sb.append("Дата рождения: ").append(birthDate).append(", ");
        sb.append("Возраст: ").append(getAge());
        if (deathDate != null) {
            sb.append(", Дата смерти: ").append(deathDate);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return gender == person.gender && Objects.equals(name, person.name) && Objects.equals(birthDate, person.birthDate) && Objects.equals(deathDate, person.deathDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, birthDate, deathDate);
    }
}
