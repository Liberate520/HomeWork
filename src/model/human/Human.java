package model.human;

import model.family_tree.FamilyTreeItem;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human implements FamilyTreeItem<Human> {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate, deathDate;
    private Human spouse;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }
    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null);
    }
    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        this(name, gender, birthDate, null, father, mother);
    }
    public Human() {
    }
    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setChildren(List<Human> children){
        this.children = children;
    }
    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }
    public boolean addParent(Human parent) {
        if (parent.gender.equals(Gender.Female)) {
            setMother(parent);
        } else if (parent.gender.equals(Gender.Male)) {
            setFather(parent);
        }
        return true;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public LocalDate getBirthDate(){
        return birthDate;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }
    public Human getMother() {
        return mother;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public Human getFather() {
        return father;
    }
    public Human getSpouse() {
        return this.spouse;
    }
    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(name, human.name) && gender == human.gender && Objects.equals(birthDate, human.birthDate) && Objects.equals(deathDate, human.deathDate) && Objects.equals(spouse, human.spouse) && Objects.equals(mother, human.mother) && Objects.equals(father, human.father) && Objects.equals(children, human.children);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, gender, birthDate, deathDate, spouse, mother, father, children);
    }
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }
    @Override
    public int getAge() {
        LocalDate date = LocalDate.now();
        if (this.deathDate != null) {
            date = this.deathDate;
        }
        return getPeriod(this.birthDate, date);
    }
    private int getPeriod(LocalDate startPeriod, LocalDate endPeriod) {
        Period diff = Period.between(startPeriod, endPeriod);
        return diff.getYears();
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return this.name;
    }
    private String getGender() {
        return this.gender.toString();
    }
    private String getSpauseInfo() {
        if (this.spouse == null)
            return "нет";
        return getSpouse().name;
    }
    private String getMotherInfo() {
        if (this.mother == null)
            return "нет информации";
        return this.mother.name;
    }
    private String getFatherInfo() {
        if (this.father == null)
            return "нет информации";
        return this.father.name;
    }
    private String getChildrenInfo() {
        if (this.children.isEmpty()) {
            return "отсутствуют";
        } else {
            String[] children = new String[this.children.size()];
            for (int i = 0; i < this.children.size(); i++) {
                children[i] = this.children.get(i).name;
            }
            return String.join(", ", children);
        }
    }
    @Override
    public String toString() {
        return getInfo();
    }
    private String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id);
        sb.append(". Имя: ").append(getName());
        sb.append(", пол: ").append(getGender());
        sb.append(", возраст: ").append(getAge());
        sb.append(", супруг(а): ").append(getSpauseInfo());
        sb.append(", мать: ").append(getMotherInfo());
        sb.append(", отец: ").append(getFatherInfo());
        sb.append(", дети: ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }
}
