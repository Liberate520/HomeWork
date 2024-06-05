package Model.Рerson;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Рerson implements Serializable {
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Рerson mother;
    private Рerson father;
    private List<Рerson> children;

    public Рerson(String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate, Рerson mother,
                 Рerson father) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }
//сбор информации
    public Рerson(String firstName, String lastName, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this(firstName, lastName, gender, birthDate, deathDate, null, null);
    }
    public Рerson(String firstName, String lastName, LocalDate birthDate, LocalDate deathDate) {
        this(firstName, lastName, null, birthDate, deathDate, null, null);
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
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
    public Рerson getMother() {
        return mother;
    }
    public Рerson getFather() {
        return father;
    }
    public List<Рerson> getChildren() {
        return children;
    }
    public void setMother(Рerson mother) {
        this.mother = mother;
    }
    public void setFather(Рerson father) {
        this.father = father;
    }
    public void setChildren(List<Рerson> children) {
        for (Рerson рerson : this.children = children) {

        }

    }
    public String getAge() {
        return "продолжительность жизни: " + Period.between(birthDate, deathDate).getYears() + " years";
    }
    public void addChild(Рerson human) {
        if (!children.contains(human)) {
            children.add(human);
        }
    }
    public String getMotherInfo() {
        String str = "мать: ";
        if (mother != null) {
            str += mother.getFirstName() + " " + mother.getLastName();
        } else {
            str += "неизвестно";
        }
        return str;
    }
    public String getFatherInfo() {
        String str = "отец: ";
        if (father != null) {
            str += father.getFirstName() + " " + father.getLastName();
        } else {
            str += "неизвестно";
        }
        return str;
    }
    public String getChildrenInfo() {
        String str = "дети: ";
        if (children.size() != 0) {
            for (Рerson child : children) {
                str += child.getFirstName() + " " + child.getLastName() + ", ";
            }
        } else {
            str += "неизвестно";
        }
        return str.replaceAll(", $", "");
    }
    @Override
    public String toString() {
        return "Имя: " + firstName + " " + lastName + ", пол: " + gender + ", дата рождения: " + birthDate +
                ", дата смерти: " + deathDate + ", " + getAge() + ", " + getMotherInfo() + ", " + getFatherInfo() +
                ", " + getChildrenInfo();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Рerson person = (Рerson) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) &&
                gender == person.gender && Objects.equals(birthDate, person.birthDate) &&
                Objects.equals(deathDate, person.deathDate) && Objects.equals(mother, person.mother) &&
                Objects.equals(father, person.father) && Objects.equals(children, person.children);
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, gender);
    }
}