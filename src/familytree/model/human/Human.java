package familytree.model.human;

import familytree.model.familytree.FamilyTreeElement;
import familytree.model.human.gender.Gender;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Human implements  Comparable<Human>, FamilyTreeElement<Human> {
    public Human(String name,  String gender) {
        this.name = name;
        this.gender = gender;
    }
    private  final String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private final String gender;
    private Human father, mother;
    private List<Human> children;

    public void SetDateOfBirth(int year, int month, int day) {
        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    public void SetDateOfDeath(int year, int month, int day) {this.dateOfDeath = LocalDate.of(year, month, day);}

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public boolean isDead(int year) {
        return year > LocalDate.now().getYear();
    }

    public String getChildren() {
        StringBuilder stringBuilder = new StringBuilder();
        if (children == null) {
            return "";
        } else {
            for (Human child : children) {
                stringBuilder.append(child.getName()).append(" | ");
            }
            return stringBuilder.toString();
        }
    }
    public String getName () {return name;}

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        return Objects.requireNonNullElse(dateOfDeath, now).getYear() - dateOfBirth.getYear();
    }
    
    public void addChild(List<Human> children, Human child) {
        children.remove(child);
        children.add(child);
    }

    public Gender getGender() {
        if (gender.equals("Мужчина")) {
            return Gender.Male;
        }
        return Gender.Female;
    }

    public String getInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Name: ").append(name).append("\n");
        stringBuilder.append("Gender: ").append(getGender()).append("\n");
        stringBuilder.append("Age: ").append(getAge()).append("\n");
        if (father != null) {stringBuilder.append("Father: ").append(father.getName()).append("\n");}
        if (mother != null) {stringBuilder.append("Mother: ").append(mother.getName()).append("\n");}
        stringBuilder.append("Children: ").append(getChildren());
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}