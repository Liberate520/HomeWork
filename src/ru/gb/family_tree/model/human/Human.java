package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.member.Gender;
import ru.gb.family_tree.model.member.Member;

import java.time.LocalDate;

public class Human extends Member {
    public Human(String name, LocalDate birthDate, Gender gender) {
        super(name, birthDate, gender);
    }

    public Human(String name, Member mother, Member father, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        super(name, mother, father, birthDate, deathDate, gender);
    }
}

//public class Human implements Serializable, Comparable<Human>, FamileTreeItems<Human> {
//    private static int idCounter = 0;
//
//    private long id;
//    private String name;
//    private Human mother, father;
//    private List<Human> child;
//    private LocalDate birthDate, deathDate;
//    private Gender gender;
//
//    /**
//     * Конструктор full
//     * @param name собственное имя
//     * @param mother имя матери или null
//     * @param father имя отца или null
//     * @param birthDate дата рождения
//     * @param deathDate дата смерти или null
//     * @param gender пол объекта (M-male, F-Female)
//     */
//    public Human(String name, Human mother, Human father, LocalDate birthDate, LocalDate deathDate, Gender gender) {
//        this.id = ++idCounter;
//        this.name = name;
//        this.mother = mother;
//        this.father = father;
//        this.child = new ArrayList<>();
//        this.birthDate = birthDate;
//        this.deathDate = deathDate;
//        this.gender = gender;
//        if (this.mother != null) {
//            this.mother.child.add(this);
//        }
//        if (this.father != null) {
//            this.father.child.add(this);
//        }
//    }
//
//    /**
//     * Конструктор short
//     * @param name собственное имя
//     * @param birthDate дата рождения
//     * @param gender пол объекта (M-male, F-Female)
//     */
//    public Human(String name, LocalDate birthDate, Gender gender) {
//        this(name,null, null, birthDate,null, gender);
//    }
//    public List<Human> getChild(){
//        return child;
//    }
//
//    public String getParents(){
//        StringBuilder sb = new StringBuilder();
//        sb.append("\n" + name + "'s Parents: \n");
//        sb.append("Mother: " + mother + "\n");
//        sb.append("Father: " + father + "\n");
//        return sb.toString();
//    }
//    public String getName(){
//        return this.name;
//    }
//
//    //найти возраст человека
//    public int getAge(){
//        if(deathDate== null){
//            return getPeriod(birthDate, LocalDate.now());
//        }
//        return getPeriod(birthDate, deathDate);
//    }
//    //вспомогательный метод для поиска возраста.
//    private int getPeriod(LocalDate start, LocalDate finish){
//        Period diff = Period.between(start, finish);
//        return diff.getYears();
//    }
//
//    @Override
//    public String toString() {
//        return "Human{" +
//                "ID ='" + id + '\'' +
//                "name='" + name + '\'' +
//                ", mother=" + toStrHelper(mother) +
//                ", father=" + toStrHelper(father) +
//                ", child=" + toStrHelperList(child) +
//                ", birthDate=" + birthDate +
//                ", deathDate=" + deathDate +
//                ", gender=" + gender +
//                '}';
//    }
//    //вместо объекта в печать возвращаем только его имя для матери и отца
//    private String toStrHelper(Human human){
//        if (human != null){
//            return human.name;
//        }
//        else return null;
//    }
//    //вместо объекта в печать возвращаем только имена детей
//    private String toStrHelperList(List<Human> list){
//        StringBuilder sb = new StringBuilder();
//        sb.append("(");
//        for (Human human: list){
//            if (sb.length() > 1){
//                sb.append(", ");
//            }
//            sb.append(human.name);
//        }
//        sb.append(")");
//        return sb.toString();
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Human human = (Human) o;
//        return id == human.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hashCode(id);
//    }
//
//
//    @Override
//    public int compareTo(Human o) {
//        return this.name.compareTo(o.name);
//    }
//}
