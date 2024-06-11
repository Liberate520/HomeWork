package ru.gb.family.familyTree.ItemFamilyTrees;

import ru.gb.family.familyTree.ItemFamilyTrees.enums.*;
import ru.gb.family.service.Service;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemFamilyTree<T extends ItemFamilyTree> extends Service implements Serializable {
    private Integer age;
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthday,dateOfDeath;
    private T father;
    private T mother;
    private List<ItemFamilyTree<T>> children;
    private T spouse;


    public ItemFamilyTree(String name, LocalDate birthday, LocalDate dateOfDeath, Gender gender) {
        id = -1;
        if (dateOfDeath == null){
           this.age = getPeriod(birthday,LocalDate.now());
        }
        else{
            this.age = getPeriod(birthday,dateOfDeath);
        }

        spouse = null;
        father = null;
        mother = null;
        this.name = name;
        this.birthday = birthday;
        this.dateOfDeath = dateOfDeath;
        this.gender = gender;
        this.children = new ArrayList<>();

    }

    public void addParent(T parent){
        if (parent.getGender() == Gender.Male){
            this.father = parent;
        }
        else{
            this.mother = parent;
        }

    }

    public void editItemFamilyTree(T addItemFamilyTree, DegreeOfKinship degreeOfKinship){
        switch(degreeOfKinship) {
            case Father, Mother :
                this.addParent(addItemFamilyTree);
                addItemFamilyTree.getChildren().add(this);
                break;
            case Spouse:
                this.addSpouse(addItemFamilyTree);
                addItemFamilyTree.addSpouse(this);
                break;
            case Children:
                this.addChildren(addItemFamilyTree);
                addItemFamilyTree.addParent(this);
                break;
        }
    }

    void addSpouse(T spouse) {
        this.spouse = spouse;
    }

    public void addChildren(ItemFamilyTree<T> child) {
        if (child != null) {
            if (children.indexOf(child) == -1) {
                children.add(child);
            }
        }
    }
    public void changedateOfDeath(LocalDate dateDeath){
        if (dateDeath != null){
            this.setDateOfDeath(dateDeath);
        }
    }

    public  int getAge(){
        if (dateOfDeath == null){
            return getPeriod(birthday,LocalDate.now());
        }
        else{
            return getPeriod(birthday,dateOfDeath);
        }
    }

    private int getPeriod(LocalDate birthday, LocalDate dateOfDeath){
        Period diff = Period.between(birthday,dateOfDeath);
        return diff.getYears();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        // список детей
        for (ItemFamilyTree<T> itemFamilyTree : children){
            stringBuilder.append(itemFamilyTree.name+" ("+age +" лет.)");
            stringBuilder.append(",\t");
        }
        return "\n id=" + id + '\t' +
                "name=" + name +" ("+age+" лет.))"+
                "\t birthday(" + birthday +
                ")\t dateOfDeath(" + dateOfDeath +
                ")\t gender=" + gender +
                "\n\t супруг(а):" + ((!(spouse == null)) ? spouse.getName() : "") +
                "\n\t Отец:" + ((!(father == null)) ? father.getName() : "") +
                "\n\t Мать:" + ((!(mother == null)) ? mother.getName() : "") +
                "\n\t дети:" + stringBuilder + "\n";

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemFamilyTree<T> ItemFamily = (ItemFamilyTree<T>) o;
        return Objects.equals(name, ItemFamily.name) && Objects.equals(birthday, ItemFamily.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday);
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public ItemFamilyTree<T> getFather() {
        return father;
    }

    public void setFather(T father) {
        this.father = father;
    }

    public T getMother() {
        return mother;
    }

    public void setMother(T mother) {
        this.mother = mother;
    }

    public List<ItemFamilyTree<T>> getChildren() {
        return children;
    }

    public void setChildren(List<ItemFamilyTree<T>> children) {
        this.children = children;
    }

    public ItemFamilyTree<T> getSpouse() {
        return spouse;
    }

    public void setSpouse(T spouse) {
        this.spouse = spouse;
    }
}
