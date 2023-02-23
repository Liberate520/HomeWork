package HW01;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Person implements Serializable {

    private String name;
    private String sex;
    private Integer dateOfBirth;
    private Integer dateOfDeath;
    private String mother;
    private String father;
    private List<String> children=new ArrayList<>();


    public Person (String name, String sex, Integer dateOfBirth, Integer dateOfDeath){
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
    }

    public Person (String name,
                   String sex,
                   Integer dateOfBirth,
                   Integer dateOfDeath,
                   String mother,
                   String father,
                   List<String> children){

        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.mother = mother;
        this.father = father;
//        children = children1;
    }

    public Person (){
        this("Unkown","Unkown", 0, 0 );
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public Integer getDateOfBirth() {
        return dateOfBirth;
    }

    public Integer getDataOfDeath() {
        return dateOfDeath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setDateOfBirth(Integer dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfDeath(Integer dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {

        this.father = father;
    }

    public List<String> getChildren() {
        return children;
    }

    public void setChildren(String child) {
        children.add(child);
    }



    @Override
    public String toString() {
        return "\nHW01.Person " +
                "name='" + name + "',\n" +
                "sex='" + sex + "',\n" +
                "dateOfBirth='" + dateOfBirth +"',\n"+
                "dateOfDeath='" + dateOfDeath +"'\n"+
                "Mother='" + mother +"'\n"+
                "Father='" + father +"'\n"+
                "Children='" + getChildren() +"'\n";
    }
}
