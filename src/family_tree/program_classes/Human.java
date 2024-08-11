package family_tree.program_classes;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Human implements Serializable, Comparable<Human> {
    private String document;
    private String name;
    private Gender gender;
    private LocalDate birthDate, deathDate;
    private String mother;
    private String father;
    private List<String> children;

    public Human(String document, String name, Gender gender, LocalDate birthDate) {
        this.document = document;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new  StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format("|%13s | " +
                "%13s |" +
                "%13s |" +
                "%14s |" +
                "%13s |" +
                "%13s |" +
                "%13s |" +
                "%50s |"
                , getNull(document),
                getNull(name),
                getNull(getGenderText(gender)),
                getNull(birthDate),
                getNull(deathDate),
                getNull(mother),
                getNull(father),
                getNull(children));

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return Objects.equals(document, human.document) && Objects.equals(name, human.name) && gender == human.gender && Objects.equals(birthDate, human.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(document, name, gender, birthDate);
    }

    public String getName() {
        return name;
    }

    public String getMother() {
        return mother;
    }

    public String getFather() {
        return father;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setParents(Human... parents) {
        if (parents.length > 2) {
            return;
        }
        else {
            for (Human parent : parents) {
                if (parent.getGender() == Gender.Female) {
                    this.mother = parent.getDocument();
                } else {
                    this.father = parent.getDocument();
                }
                parent.addChild(this);
            }
        }
    }

    public void  addChild(Human child) {
        if (!this.children.equals(child.getDocument())) {
            this.children.add(child.getDocument());
        }
        if (this.gender == Gender.Male) {
            child.father = this.document;
        }
        else if (this.gender == Gender.Female) {
            child.mother = this.document;
        }

    }

    public String getDocument() {
        return document;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    private String getGenderText(Gender value) {
        if (value == Gender.Male) {
            return "Мужской";
        }
        else {
            return "Женский";
        }
    }

    private Object getNull(Object o) {
        Object answer;
        if (o == null || o.toString()=="[]") {
            answer = "нет данных";
        }
        else {
            answer = o;
        }
        return answer;
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}
