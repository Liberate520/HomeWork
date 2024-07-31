package family_tree.human;

import family_tree.family_tree.ItemFamilyTree;

import java.io.Serializable;
import java.time.LocalDate;

public class Human implements Serializable, ItemFamilyTree {
    private int id;
    private String name;
    private LocalDate dob, dod;
    private Gender gender;
    private Human father, mather;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public LocalDate getDob() {
        return dob;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDod() {
        return dod;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMather() {
        return mather;
    }

    public void setMather(Human mather) {
        this.mather = mather;
    }



    @Override
    public String toString() {
        return id + ", имя: " + name + ", дата рождения: " + dob + ", дата смерти: " + dod + ", пол: " + gender;
    }


}
