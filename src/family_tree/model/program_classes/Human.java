package family_tree.model.program_classes;

import family_tree.model.help_classes.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Human implements Serializable, FamilyTreeItem<Human> {
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
        return Objects.equals(document, human.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(document);
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

    public int setParents(Object... parents) {
        int status = 0;
        if (parents.length <= 2) {
            for (Object o : parents) {
                if (getClass() != o.getClass()) {
                    continue;
                }
                else {
                    Human parent = (Human) o;
                    if (parent.getGender() == Gender.Female) {
                        this.mother = parent.getDocument();
                    } else {
                        this.father = parent.getDocument();
                    }
                    parent.addChild(this);
                    status++;
                }
            }
        }
        return status;
    }

    public void  addChild(Object o) {
        if (getClass() != o.getClass()) {
            return;
        }
        Human child = (Human) o;
        if (!this.children.contains(child.getDocument())) {
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
