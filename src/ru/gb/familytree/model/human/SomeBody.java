package ru.gb.familytree.model.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public abstract class SomeBody implements Serializable {

    private long id;
    private String name;
    private LocalDate birth;
    private LocalDate death;
    private int age;
    private Gender gender;
    private List<SomeBody> parents;
    private List<SomeBody> children;


    public SomeBody(String name, LocalDate birth, LocalDate death, int age, Gender gender, SomeBody father, SomeBody mother){
        id = -1;
        this.name = name;
        this.birth = birth;
        this.death = death;
        this.gender = gender;
        this.age = age;
        children = new ArrayList<>();
        parents = new ArrayList<>();
        if (father != null){
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }
    }

    public SomeBody(String name, int age, Gender gender) {
        this(name, null, null, age, gender, null, null);
    }

//    public Human (String name, LocalDate birth, int age, Gender gender, Human father, Human mother) {
//        this(name, birth, null, null, gender, father, mother);
//    }

    public boolean addChild(SomeBody child) {
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(SomeBody parent) {
        if(!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
    }

    public SomeBody getFather() {
        for(SomeBody parent : parents){
            if (parent.getGender() == Gender.MALE){
                return parent;
            }
        }
        return null;
    }

    public SomeBody getMother() {
        for(SomeBody parent : parents){
            if (parent.getGender() == Gender.FEMALE){
                return parent;
            }
        }
        return null;
    }

    private int getDate(LocalDate birth, LocalDate death){
        Period date = Period.between(birth, death);
        return date.getYears();
    }

//    public int getAge(){
//        if(death == null){
//            return getDate(birth, LocalDate.now());
//        } else {
//            return getDate(birth, death);
//        }
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public LocalDate getDeath() {
        return death;
    }

    public void setDeath(LocalDate death) {
        this.death = death;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<SomeBody> getParents() {
        return parents;
    }

    public void setParents(List<SomeBody> parents) {
        this.parents = parents;
    }

    public List<SomeBody> getChildren() {
        return children;
    }

    public void setChildren(List<SomeBody> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(gender);
        sb.append(", возраст: ");
        sb.append(age);
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getMotherInfo(){
        String res = "мать: ";
        SomeBody mother = getMother();
        if (mother != null){
            res += mother.getName();
        } else {
            res += "неизвестно: ";
        }

        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        SomeBody father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестно: ";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("нет");
        }
        return res.toString();
    }
}
