package ru.gb.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate dob, dod;
    private List<Human> childsArray;
    private List<Human> parentsArray;

    public Human(String firstName, String lastName, LocalDate dob, LocalDate dod, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;
        this.childsArray = new ArrayList<>();
        this.parentsArray = new ArrayList<>();
    }

    public Human(String firstName, String lastName, LocalDate dob, LocalDate dod, Gender gender, Human father, Human mother) {
        this(firstName, lastName, dob, dod, gender);

        if(father != null) {
            this.parentsArray.add(father);
        }
        if(mother != null) {
            this.parentsArray.add(mother);
        }

    }

    public Human(String firstName, String lastName, LocalDate dob, LocalDate dod, Gender gender, Human father, Human mother, Human... children) {
        this(firstName, lastName, dob, dod, gender, father, mother);

        if(children != null){
            for (Human child : children) {
                this.childsArray.add(child);
            }
        }
    }


    public String getFirstName() {
        return firstName;
    }

    public void addChilds(Human... childs) {
        for (Human ch : childs) {
            this.childsArray.add(ch);
        }


    }
    public void addParent(Human parent) {
        this.childsArray.add(parent);
    }


    public List<Human> getChildsArray() {
        return childsArray;
    }



    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("\n" + firstName + " " + lastName + ", " + gender + ", " + " (" + dob + " - " + dod + ")");
        if (parentsArray.isEmpty()!=true){
            str.append("\nParents: \n");
            for (int i = 0; i < parentsArray.size(); i++) {

                if (i == parentsArray.size()-1){
                    str.append(parentsArray.get(i).firstName).append(" ").append(parentsArray.get(i).lastName);
                }
                else str.append(parentsArray.get(i).firstName).append(" ").append(parentsArray.get(i).lastName).append(", ");
            }
        }
        if (childsArray.isEmpty()!=true){
            str.append("\nChilds: \n");
            for (int i = 0; i < childsArray.size(); i++) {

                if (i == childsArray.size()-1){
                    str.append(childsArray.get(i).firstName).append(" ").append(childsArray.get(i).lastName);
                }
                else str.append(childsArray.get(i).firstName).append(" ").append(childsArray.get(i).lastName).append(", ");
            }
        }
        String res = String.valueOf(str);
        return res;
    }
}

