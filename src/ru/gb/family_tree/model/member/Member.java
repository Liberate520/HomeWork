package ru.gb.family_tree.model.member;

import ru.gb.family_tree.model.tree.FamileTreeItems;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
Общий абстрактный класc
 */
public abstract class Member implements Serializable, Comparable<Member>, FamileTreeItems<Member> {
    private static int idCounter = 0;

    private long id;
    private String name;
    private Member mother, father;
    private List<Member> child;
    private LocalDate birthDate, deathDate;
    private Gender gender;

    /**
     * Конструктор full
     * @param name собственное имя
     * @param mother имя матери или null
     * @param father имя отца или null
     * @param birthDate дата рождения
     * @param deathDate дата смерти или null
     * @param gender пол объекта (M-male, F-Female)
     */
    public Member(String name, Member mother, Member father, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this.id = ++idCounter;
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.child = new ArrayList<>();
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        if (this.mother != null) {
            this.mother.child.add(this);
        }
        if (this.father != null) {
            this.father.child.add(this);
        }
    }

    /**
     * Конструктор short
     * @param name собственное имя
     * @param birthDate дата рождения
     * @param gender пол объекта (M-male, F-Female)
     */
    public Member(String name, LocalDate birthDate, Gender gender) {
        this(name,null, null, birthDate,null, gender);
    }

    public List<Member> getChild(){
        return child;
    }

    public String getParents(){
        StringBuilder sb = new StringBuilder();
        sb.append("\n" + name + "'s Parents: \n");
        sb.append("Mother: " + mother + "\n");
        sb.append("Father: " + father + "\n");
        return sb.toString();
    }
    public String getName(){
        return this.name;
    }

    //найти возраст человека
    public int getAge(){
        if(deathDate== null){
            return getPeriod(birthDate, LocalDate.now());
        }
        return getPeriod(birthDate, deathDate);
    }
    //вспомогательный метод для поиска возраста.
    private int getPeriod(LocalDate start, LocalDate finish){
        Period diff = Period.between(start, finish);
        return diff.getYears();
    }

    @Override
    public String toString() {
        return "{" + this.getClass().getSimpleName() + "; " +
                "ID ='" + id + '\'' +
                "name='" + name + '\'' +
                ", mother=" + toStrHelper(mother) +
                ", father=" + toStrHelper(father) +
                ", child=" + toStrHelperList(child) +
                ", birthDate=" + birthDate +
                ", deathDate=" + deathDate +
                ", gender=" + gender +
                '}';
    }
    //вместо объекта в печать возвращаем только его имя для матери и отца
    private String toStrHelper(Member member){
        if (member != null){
            return member.name;
        }
        else return null;
    }
    //вместо объекта в печать возвращаем только имена детей
    private String toStrHelperList(List<Member> list){
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (Member member: list){
            if (sb.length() > 1){
                sb.append(", ");
            }
            sb.append(member.name);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


    @Override
    public int compareTo(Member o) {
        return this.name.compareTo(o.name);
    }
}
