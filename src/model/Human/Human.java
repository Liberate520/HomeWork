package model.Human;

import model.FamilyTree.FamilyItem;
import model.Gender.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, FamilyItem {
    private String name;
    private List<Human> parents;
    private List<Human> children;
    private LocalDate birthDate, deathDate;
    private Gender gender;

    private int idFamilyItem;

    public Human(int id, String name, Gender gender, LocalDate birthDate){
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.idFamilyItem = id;

    }

    public int getIdFamilyItem() {
        return idFamilyItem;
    }

    public int getAge(){
        return LocalDate.now().compareTo(birthDate);
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id: "+idFamilyItem+" name: "+name+"; gender: "+gender+"; birthDate: "+birthDate+"; deathDate: "+deathDate); //+"; parents: "+getParents()+"; children: "+getChildren());
        if (!parents.isEmpty()){
            stringBuilder.append("; "+getParents());
        }
        if (children.size()!=0){
            stringBuilder.append("; "+getChildren());
        }


        return stringBuilder.toString();
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    public void addParent(Human parent){
        this.parents.add(parent);
    }

    public String getList(List<Human> humans) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human : humans){
            if (human!=null) {
                stringBuilder.append(human.name);
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    public String getChildren() {
        return "Children: "+getList(children);
    }

    public String getParents() {
        return "Parents: "+getList(parents);
    }

    public String getSistersAndBrothers() {
        Human parent = parents.getLast();
        StringBuilder stringBuilder = new StringBuilder();
        if (parent!=null) {
            for (Human human : parent.children) {
                if ((human != null) & (human != this)) {
                    stringBuilder.append(human.name);
                    stringBuilder.append(", ");
                }
            }
        }
        return "Sisters and brothers: "+stringBuilder;
    }

}
