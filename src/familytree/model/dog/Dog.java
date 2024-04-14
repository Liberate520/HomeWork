package familytree.model.dog;

import familytree.model.familytree.FamilyTreeElement;
import familytree.model.human.gender.Gender;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Dog implements FamilyTreeElement<Dog>, Comparable<Dog> {
    private  final String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private final String gender;
    private final Dog father, mother;
    private List<Dog> children;

    public Dog(String name, String gender, Dog father, Dog mother) {
        this.name = name;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
    }

    public void SetDateOfBirth(int year, int month, int day) {
        this.dateOfBirth = LocalDate.of(year, month, day);
    }

    public void SetDateOfDeath(int year, int month, int day) {this.dateOfDeath = LocalDate.of(year, month, day);}

    public String getName() {
        return name;
    }

    public void setChildren(List<Dog> children) {this.children = children;}

    public void addChild(List<Dog> children, Dog child) {
        children.remove(child);
        children.add(child);
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        return Objects.requireNonNullElse(dateOfDeath, now).getYear() - dateOfBirth.getYear();
    }

    public String getChildren() {
        StringBuilder stringBuilder = new StringBuilder();
        if (children == null) {
            return "";
        } else {
            for (Dog child : children) {
                stringBuilder.append(child.getName()).append(" | ");
            }
            return stringBuilder.toString();
        }
    }

    public Gender getGender() {
        if (gender.equals("Male")) {
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
    public int compareTo(Dog o) {
        return name.compareTo(o.name);
    }
}
