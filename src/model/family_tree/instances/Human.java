package model.family_tree.instances;

import model.family_tree.tree.TreeItem;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Human implements Serializable, Comparable<Human>, TreeItem<Human>, IFamily {
    private long id;
    private String name;
    private Human mother, father;
    private List<IFamily> children;
    private Date birthDate, deathDate;
    private int age;
    private Gender gender;
    private Human spouse; // Реализовать

    /**
     * Человек со всеми отребутами
     * @param name Имя
     * @param mother Отец
     * @param father Мать
     * @param birthDate День рождения
     * @param deathDate Дата смерти
     * @param gender Пол
     */
    public Human(String name, Human mother, Human father, Date birthDate, Date deathDate, Gender gender) {
        id = - 1;
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;

        this.children = new ArrayList<>();
    }
    /**
     * Человек еще жевущий
     * @param name Имя
     * @param mother Отец
     * @param father Мать
     * @param birthDate День рождения
     * @param gender Пол
     */
    public Human(String name, Human mother, Human father, Date birthDate, Gender gender){
        this(name, mother, father, birthDate, null, gender);
    }
    /**
     * Человек без родителей и умерший (самый первый предок)
     * @param name Имя
     * @param birthDate День рождения
     * @param deathDate День смерти
     * @param gender Пол
     */
    public Human(String name, Date birthDate, Date deathDate, Gender gender){
        this(name, null, null, birthDate, deathDate, gender);
    }

    /**
     * Человек живущий но без связей
     * @param name Имя
     * @param birthDate Дата рождения
     * @param gender Пол
     */
    public Human(String name, Date birthDate, Gender gender){
        this(name, birthDate, null, gender);
    }

    /*--------------Геттеы----------------*/
    public String getName() {
        return name;
    }
    public Human getMother() {
        return mother;
    }
    public Human getFather() {
        return father;
    }
    public List<IFamily> getChildren() {
        return children;
    }
    public Date getBirthDate() {
        return birthDate;
    }
    public Date getDeathDate() {
        return deathDate;
    }
    public int getAge() {
        if(deathDate==null){
            LocalDate currentDate = LocalDate.now();
            return currentDate.getYear() - birthDate.getYear() - 1900;
        }else {
            return deathDate.getYear() - birthDate.getYear();
        }
    }
    public Gender getGender() {
        return gender;
    }

    /*--------------Сеттеры----------------*/
    @Override
    public void setMother(Human mother) {
        if(this.mother == null){
            this.mother = mother;
        }
    }
    @Override
    public void setFather(Human father) {
        if(this.father == null){
            this.father = father;
        }
    }
    public void setDeathDate(Date deathDate) {
        if(this.deathDate==null){
            this.deathDate = deathDate;
        }
    }

    /*--------------Методы----------------*/
    /**
     * Добавление ребенка
     * @param child Ребенок
     */
    @Override
    public boolean addChild(Human child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Имя: " + name + "; ");

        if(gender == Gender.Male){
            stringBuilder.append("Пол: мужской; ");
        }else {
            stringBuilder.append("Пол: женский; ");
        }

        stringBuilder.append("Дата рождения: " + formater.format(birthDate) + "; ");

        if(deathDate != null ){
            stringBuilder.append("Дата смерти: " + formater.format(deathDate) + "; ");
        }
        stringBuilder.append("Возраст: " + getAge() + "; ");

        if(mother != null){
            stringBuilder.append("Имя матери: " + mother.getName() + "; ");
        }
        if(father != null){
            stringBuilder.append("Имя отца: " + father.getName() + "; ");
        }

        if(children != null){
            for (IFamily child : children) {
                stringBuilder.append("Имя ребенка: " + child.getName() + "; ");
            }
        }

        return stringBuilder.toString();
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}
