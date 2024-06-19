package model.human;

import model.tree.TreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, TreeItem<Human> {

    private long id;
    private String name;
    private String lastName;
    private LocalDate  dateOfBirth, dateOfDeath;
    private List<Human> children;
    private Human father, mother;
    private Gender gender;
    private Human spouse;

    public Human (String name, String lastName, LocalDate dateOfBirth, LocalDate dateOfDeath, Gender gender, Human mother, Human father, Human spouse){
        id = -1;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        if (dateOfDeath != null) { // заимствовал. не думал что так можно
            this.dateOfDeath = dateOfDeath;
        }
        if (mother != null) {
            this.mother = mother;
        }
        if (father != null) {
            this.father = father;
        }
        children = new ArrayList<>(); // заимствовал
        if(spouse!=null) {
            this.setSpouse(spouse);
        }
    }
    public Human (String name, String lastName, LocalDate dateOfBirth, LocalDate dateOfDeath, Gender gender, Human mother, Human father){
        this(name, lastName, dateOfBirth, dateOfDeath, gender, mother, father, null);
    }
    public Human (String name, String lastName, LocalDate dateOfBirth, Gender gender){
        this(name, lastName, dateOfBirth, null, gender, null, null);
    }
    public Human (String name, String lastName, LocalDate dateOfBirth, Gender gender, Human mother, Human father){
        this(name, lastName, dateOfBirth, null, gender, mother, father);
    }
    public Human (String name, String lastName, LocalDate dateOfBirth,LocalDate dateOfDeath, Gender gender){
        this(name, lastName, dateOfBirth, dateOfDeath, gender, null, null);
    }

    // get\set
    public long  getId() {
        return id;
    }
    public void setID(long id){
        this.id = id;
    }
    public String  getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String  getLastName() {
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public LocalDate  getDateOfBirth() {
        return dateOfBirth;
    }
    public boolean setDateOfBirth(LocalDate dateOfBirth){
        if(dateOfBirth.isAfter(this.dateOfDeath)){
            this.dateOfBirth=dateOfBirth;
            return true;
        } else {
            return false;
        }
    }
    public LocalDate  getDateOfDeath() {
        return dateOfDeath;
    }
    public boolean setDateOfDeath(LocalDate DateOfDeath){
        if(this.dateOfBirth.isAfter(dateOfDeath)){
            this.dateOfDeath=dateOfDeath;
            return true;
        } else {
            return false;
        }
    }
    public int getAge(){
        if(dateOfDeath!=null) {
            return (int) ChronoUnit.YEARS.between(dateOfBirth, dateOfDeath);
        }else{
            return (int) ChronoUnit.YEARS.between(dateOfBirth, LocalDate.now());
        }
    }

    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender){
        this.gender = gender;
    }
    public Human getSpouse(){
        return spouse;
    }
    public void setSpouse(Human human){
        if(human.spouse==null){
            this.spouse=human;
            human.spouse=this;
        }
    }

    public List<Human> getChildren() {
        return children;
    }
    public int getChildrenListSize(){
        return children.size();
    }
    public String getStringListChildren() {
        return children.toString(); // не уверен что будет работать.
    }
    public boolean addChildToList(Human child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }
    public boolean removeChildFromList(Human child){
        //на случай если добавлен по ошибке
        if (!children.contains(child)){
            children.remove(child);
            return true;
        }
        return  false;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
        if(father != null){
            father.addChildToList(this);
        }
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
        if(mother != null){
            mother.addChildToList(this);
        }
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ");
        sb.append(id);
        sb.append("\t| ");
        sb.append(name);
        sb.append(" ");
        sb.append(lastName);
        sb.append("\t\t| Родители: ");
        if( getFather() != null ) {
            sb.append(getFather().getName());
        } else {
            sb.append("неизвестно");
        }
        sb.append(" и ");
        if( getMother() != null ) {
            sb.append(getMother().getName());
        }else {
            sb.append(" неизвестно");
        }
        if( getFather() != null ) {
            sb.append(" " +  getFather().getLastName());
        } else {
            sb.append(" неизвестно");
        }
        sb.append("\t| даты: ");
        sb.append(getDateOfBirth());
        if(getDateOfDeath()!=null) {
            sb.append(" - ");
            sb.append(getDateOfDeath());
        }
        sb.append("\t| возраст: ");
        sb.append(getAge());
        sb.append("\n\t\t| супруг: ");
        if(getSpouse()!=null) {
            sb.append(getSpouse().getName() + " " + getSpouse().getLastName());
        }
        sb.append("\t| дети: " + getChildInfo());
        return sb.toString();
    }
    public String getChildInfo(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < children.size(); i++){
            sb.append(children.get(i).getName()+"\n");
        }

        return sb.toString();
    }
    public String getHTML(){
        StringBuilder tmp = new StringBuilder();
        tmp.append("<ul>\n" +
                "<li>\n");
        String nameOfSpouse = "";
        if(getSpouse()!=null){
            nameOfSpouse = " & id:" + getSpouse().id+" "+ getSpouse().getName();
        }
        tmp.append("<b>" + getLastName()+"<br>id:"+id+" "+getName()+" </b><i>"+ nameOfSpouse + "</i>\n");
        tmp.append("</li>\n");
        //System.out.println(getLastName()+" "+getName() +children.size());
        for(int i = 0; i < children.size(); i++){
            //System.out.println(children.get(i).getName());
            tmp.append(children.get(i).getHTML());
        }
        tmp.append("</ul>\n");
        return tmp.toString();
    }

    @Override
    public String toString() {
        return "model.human.Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfDeath=" + dateOfDeath +
                //", children=" + children +
                ", father=" + father +
                ", mother=" + mother +
                ", gender=" + gender +
                //", spouse=" + spouse +
                '}';
    }
    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}

