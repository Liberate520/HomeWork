package ru.gb.family_tree.humen;

import ru.gb.family_tree.family_tree.TreeNode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, TreeNode {
    private long id;
    private String name;
    private Gender  gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> parents;
    private List<Human> childrens;
    private Human spouse;


    public Human(String name,
                 Gender gender,
                 LocalDate birthDate,
                 LocalDate deathDate,
                 Human father,
                 Human mother){
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        parents = new ArrayList<>();
        if (father != null){
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }
        childrens = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate){
        this(name, gender, birthDate, null, null, null );
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother){
        this(name, gender, birthDate, null, father, mother );
    }

//    public boolean addChild(Human child){
//        if(!childrens.contains(child)){
//            childrens.add(child);
//            return true;
//        }
//        return false;
//    }

    public boolean addChild(Human child) {
        if (!childrens.contains(child)) {
            childrens.add(child);
            if (!child.getParents().contains(this)) {
                child.addParent(this);
            }
            return true;
        }
        return false;
    }
    public boolean addParent(Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
            if (!parent.getChildrens().contains(this)) {
                parent.addChild(this);
            }
            return true;
        }
        return false;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getFather(){
        for (Human parent: parents){
            if (parent.getGender() == gender.Male){
                return parent;
            }
        }
        return null;
    }
    public Human getMother(){
        for (Human parent: parents){
            if (parent.getGender() == gender.Female){
                return parent;
            }
        }
        return null;
    }

    @Override
    public boolean addChild(Object human) {
        return false;
    }

    @Override
    public boolean addParent(Object human) {
        return false;
    }

    public int getAge(){
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        }
        else{
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate,deathDate);
        return diff.getYears();
    }

    public void setSpouse(Human spouse){
        this.spouse = spouse;

    }

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

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public List<Human> getParents() {
        return parents;
    }

    public void setParents(List<Human> parents) {
        this.parents = parents;
    }

    public List<Human> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<Human> childrens) {
        this.childrens = childrens;
    }

    public Human getSpouse() {
        return spouse;
    }

    @Override
    public void setSpouse(Object human) {

    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", name: ");
        sb.append(name);
        sb.append(", gender: ");
        sb.append(getGender());
        sb.append(", age: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrensInfo());
        return sb.toString();
    }

    public String getSpouseInfo(){
        String res = "spouse: ";
        if (spouse == null){
            res += "no";
        }
        else {
            res  += spouse.getName();
        }
        return res;
    }
    public String getMotherInfo(){
        String res = "mother: ";
        Human mother = getMother();
        if (mother == null){
            res += "no";
        }
        else {
            res  += mother.getName();
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "father: ";
        Human father = getFather();
        if (father == null){
            res += "no";
        }
        else {
            res  += father.getName();
        }
        return res;
    }
    public String getChildrensInfo(){
        StringBuilder res = new StringBuilder();
        res.append("childrens: ");
        if (childrens.size() != 0) {
            res.append(childrens.get(0).getName());
            for (int i = 1; i < childrens.size(); i++) {
                res.append(", ");
                res.append(childrens.get(i).getName());
            }
        }
        else {
            res.append("no");
        }
        return res.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}



