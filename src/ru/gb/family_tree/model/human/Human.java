package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.family_tree.FamilyTreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Human implements Serializable, FamilyTreeItem<Human> {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getGender(Gender gender) {
        if (gender == Gender.Male){
            return "мужской";
        } else {
            return  "женский";
        }
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String DatetoString(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localDate.format(formatter);
    }

    public String getDeathDate() {
        if (deathDate == null) {
            return "";
        } else {
            return "дата смерти: " + DatetoString(deathDate) + ", ";
        }
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "{id = " + id +
                ", " + name +
                ", пол " + getGender(gender) +
                ", дата рождения: " + DatetoString(birthDate) +
                ", " + getDeathDate() +
                '}';
    }

/**


    private List<Human> parents;
    private List<Human> children;


    public Human(int id, String name, Gender gender, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.parents = parents;
        this.children = children;
    }






    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setParents(List<Human> parents) {
        this.parents = parents;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public StringBuilder getParents(List<Human> parents) {
        StringBuilder sb = new StringBuilder();
        if (parents != null) {
            for (Human parent : parents) {
                if (parent.gender == Gender.Male){
                    sb.append("отец: " + parent.getName() + ", ");
                } else {
                    sb.append("мать: " + parent.getName() + ", ");
                }
            }
        } else {
            sb.append("родители неизвестны, ");
        }
        return sb;
    }

    public StringBuilder getChildren(List<Human> children) {
        StringBuilder sb = new StringBuilder();
        if (children != null) {
            for (Human child : children) {
                if (child.gender == Gender.Male){
                    sb.append("сын: " + child.getName() + ", ");
                } else {
                    sb.append("дочь: " + child.getName() + ", ");
                }
            }
            sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
        } else {
            sb.append("детей нет‚");
        }
        return sb;
    }

    @Override
    public String toString() {
        return "Human{" +
                id +
                ", имя: " + name +
                ", пол: " + getGender() +
                ", дата рождения: " + DatetoString(birthDate) +
                ", " + getDeathDate() +
                getParents(parents) +
                getChildren(children) +
                '}';
    }

     */

}

