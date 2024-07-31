package model.human;

import model.family.GroupItem;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements GroupItem<Human> {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private Human spouse;
    private List<Human> children;

    public Human(){
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate,LocalDate deathDate, Human mother, Human father){
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        children = new ArrayList<>();
        this.mother = mother;
        this.father = father;
    }
//
//    public Human(String name, Gender gender, LocalDate birthDate){
//        this(name, gender, birthDate, null, null, null);
//    }
//
//    public Human(String name, Gender gender, LocalDate birthDate, Human mother, Human father){
//        this(name, gender, birthDate, null, mother, father);
//    }

    public Human(int id, String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        children = new ArrayList<>();
    }

    public Human(int id, String name, Gender gender, LocalDate birthDate, Human mother, Human father) {
        this(name, gender, birthDate, null, mother, father);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        try {
            return name;
        } catch (Exception e) {
            return null;
        }
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
        if (Objects.isNull(deathDate)) {
            LocalDate now = LocalDate.now();
            return Period.between(birthDate, now).getYears();
        } else {
            return Period.between(birthDate, deathDate).getYears();
        }
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void addParent(Human parent){
        if (parent.getGender().equals(Gender.MALE)){
            setFather(parent);
        } else if (parent.getGender().equals(Gender.FEMALE)) {
            setMother(parent);
        }
    }

    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if (father != null){
            list.add(father);
        }
        if (mother != null){
            list.add(mother);
        }
        return list;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public void setChildren(Human child){

        if (!children.contains(child)){
            children.add(child);
        }
    }

    public List<Human> getChildren() {
        if (children == null) {
            children = new ArrayList<>();
        }
        return children;
    }

    public List<String> getChildrenName() {
        List<String> kids = new ArrayList<>();
        for (Human child : children) {
            kids.add(child.getName());
        }
        return kids;
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
                ", дети: " + (!children.isEmpty() ? getChildrenName() : "отсуствует");
    }

    @Override
    public int compareTo(Human o) {
        return this.name.compareTo(o.name);
    }

}
