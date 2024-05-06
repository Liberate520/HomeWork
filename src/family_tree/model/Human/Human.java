package family_tree.model.Human;

import family_tree.model.FamilyTree.FamilyTreeElements;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, FamilyTreeElements<Human> {

    private String name;
    private LocalDate dob, dod;
    private Gender gender;
    private List<Human> children = new ArrayList<>();
    private Human mother;
    private Human father;



    public Human(String name, LocalDate dob, LocalDate dod, Gender gender, List<Human> children, Human mother, Human father) {

        this.name = name;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;
        this.children = children != null ? children : new ArrayList<>();
        this.mother = mother;
        this.father = father;
    }

    public Human(String name) {

        this.name = name;
    }


    public void addChild(Human child){
        children.add(child);
    }


    public String getName() {
        return name;
    }



    public LocalDate getDob() {
        return dob;
    }

    public LocalDate getDod() {
        return dod;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setChildren(List<Human> children) {
        this.children = children != null ? children : new ArrayList<>();
    }

    public String getNameChildren(List<Human> children) {
        StringBuilder sb = new StringBuilder();
        for (Human human : children) {
            sb.append(STR."\{human.getName()} ");
        }
        return sb.toString();
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Human{")
                .append("name='").append(name)
                .append(", dob=").append(dob)
                .append(", dod=").append(dod)
                .append(", gender=").append(gender != null ? gender : "null")
                .append(", children=").append(getNameChildren(children))
                .append(", mother=").append(mother != null ? mother.getName() : "null")
                .append(", father=").append(father != null ? father.getName() : "null")
                .append('}');
        return sb.toString();
    }



}