package ru.gb.family_tree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Human implements Serializable, Comparable<Human> {
    private int id;
    private String name;
    private int age;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> parents;
    private List<Human> children;

    public String DatetoString(LocalDate localDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return localDate.format(formatter);
    }
    public Human(int id, String name, Gender gender, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.parents = parents;
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        if (gender == Gender.Male){
            return "мужской";
        } else {
            return  "женский";
        }
    }

    public String getDeathDate() {
        if (deathDate == null) {
            return "";
        } else {
            return "дата смерти: " + DatetoString(deathDate) + ", ";
        }
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

