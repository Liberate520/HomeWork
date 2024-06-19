package ru.gb.family_tree.human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Human mother, father;
    private List<String> child;
    private LocalDate birthDate, deathDate;
    private Gender gender;

    /**
     * Конструктор
     * @param name собственное имя
     * @param mother имя матери или null
     * @param father имя отца или null
     * @param birthDate дата рождения
     * @param deathDate дата смерти или null
     * @param gender пол объекта (M-male, F-Female)
     */
    public Human(String name, Human mother, Human father, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.child = new ArrayList<>();
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        if (this.mother != null) {
            this.mother.child.add(name);
        }
        if (this.father != null) {
            this.father.child.add(name);
        }
    }

    public String getParents(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n" + name + "'s Parents: \n");
        sb.append("Mother: " + mother + "\n");
        sb.append("Father: " + father + "\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", mother=" + toStrHelper(mother) +
                ", father=" + toStrHelper(father) +
                ", child=" + child +
                ", birthDate=" + birthDate +
                ", deathDate=" + deathDate +
                ", gender=" + gender +
                '}';
    }
    //вместо объекта в печать возвращаем только его имя для матери и отца
    private String toStrHelper(Human human){
        if (human != null){
            return human.name;
        }
        else return null;
    }
}
