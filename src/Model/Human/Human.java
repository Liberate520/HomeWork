package src.Model.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import src.Model.FamilyTree.FamilyMember;

public class Human implements FamilyMember<Human> {
    private long id;
    private String name;
    private LocalDate dateofbirth;
    private LocalDate dateofdeath;
    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(long id, String name, LocalDate dateofbirth, LocalDate dateofdeath, Gender gender, Human mother,
            Human father, List<Human> children) {
        this.id = id;
        this.name = name;
        this.dateofbirth = dateofbirth;
        this.dateofdeath = dateofdeath;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
    }

    public Human(long id, String name, LocalDate dateofbirth, Gender gender) {
        this.id = id;
        this.name = name;
        this.dateofbirth = dateofbirth;
        this.gender = gender;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return dateofbirth;
    }

    public LocalDate getDeathDate() {
        return dateofdeath;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setID(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public void setDeathDate(LocalDate dateofdeath) {
        this.dateofdeath = dateofdeath;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setChildren(Human child) {
        if (this.children == null) {
            this.children = new ArrayList<>();
        }
        this.children.add(child);
    }

    public void addParentOrChild(Human child, Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            child.setFather(parent);
        }
        if (parent.getGender().equals(Gender.Female)) {
            child.setMother(parent);
        }
        parent.setChildren(child);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Информация о члене семьи: \n");
        sb.append("ID: ").append(id).append("\n");
        sb.append("Имя: ").append(name).append("\n");
        if (dateofbirth != null) {
            sb.append("Дата рождения: ").append(dateofbirth).append("\n");
        }
        if (dateofdeath != null) {
            sb.append("Дата смерти: ").append(dateofdeath).append("\n");
        }
        if (gender != null) {
            sb.append("Пол: ").append(gender).append("\n");
        }
        if (mother != null) {
            sb.append("Мать: ").append(mother.getName()).append("\n");
        }
        if (father != null) {
            sb.append("Отец: ").append(father.getName()).append("\n");
        }
        if (children != null) {
            if (!children.isEmpty()) {
                String childrenCollected = children.stream().map(Human::getName).collect(Collectors.joining(", "));
                sb.append("Дети: ").append(childrenCollected).append("\n");
            }
        }
        return sb.toString();
    }
}