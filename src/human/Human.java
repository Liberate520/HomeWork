package human;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate, deathDate;
    private Human mother;
    private Human father;
    private Human spouse;
    private List<String> children;

    public Human(int id, String name, Gender gender, LocalDate birthDate){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        children = new ArrayList<>();
    }

    public Human(){
        children = new ArrayList<>();
    }

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(Human kid) {
        children.add(kid.getName());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getAge() {
        LocalDate now = LocalDate.now();
        return Period.between(birthDate, now).getYears();
    }


    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public String getMother() {
        return mother.getName();
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public String getFather() {
        return father.getName();
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public String getSpouse() {
        return spouse.getName();
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }


    @Override
    public String toString() {
        return "id=" + id +
                ", имя: " + name  +
                ", пол: " + gender +
                ", возраст: " + getAge() +
                ", дата смерти: " + (deathDate != null ? deathDate : "Неизвестно") +
                ", мать: " + (mother != null ? mother.getName() : "Неизвестно") +
                ", отец: " + (father != null ? father.getName() : "Неизвестно") +
                ", супруг(а): " + (spouse != null ? spouse.getName() : "отсуствует") +
                ", дети: " + (!children.isEmpty() ? children : "отсуствует");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return id == human.id &&
                Objects.equals(name, human.name) &&
                gender == human.gender &&
                Objects.equals(birthDate, human.birthDate) &&
                Objects.equals(deathDate, human.deathDate) &&
                Objects.equals(mother, human.mother) &&
                Objects.equals(father, human.father) &&
                Objects.equals(spouse, human.spouse) &&
                Objects.equals(children, human.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, birthDate, deathDate, mother, father, spouse, children);
    }


}
