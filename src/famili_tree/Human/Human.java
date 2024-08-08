package Human;




import Pol.Pol;

import java.io.Serializable;
import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;


public class Human implements Serializable, Comparable<Human>, FamilyTreeItem<Human> {
    private String name;
    private String familiya;
    private Pol pol;
    private Human suprug;
    private LocalDate birthDate, dethDate;
    private List <Human> parents;
    private List <Human> children;
    private int age;
    private int id;


    public Human( String name, String familiya, String pol, String birthDate, String dethDate ){

        this.name= name;
        this.familiya=familiya;
        this.suprug=null;
        if (pol.equals("man")){
            this.pol = Pol.valueOf("man");
        }else if (pol.equals("woman")){
            this.pol = Pol.valueOf("woman");
        }else{
            System.out.println("vvedite pol: man ili woman");
        }

        this.children= new ArrayList<>();
        this.parents= new ArrayList<>();

        setId();


        this.birthDate=setBirtdayDate(birthDate);
        setAge();

        if (dethDate != null && !dethDate.equals("")){

            this.dethDate=setdethDate(dethDate);
        }


    }


    public Human( String name, String familiya, String pol, String birthDate  ){
        this (name,  familiya,  pol, birthDate,  null);
    }

    public  void setId(){
        Random rnd= new Random();
        this.id=rnd.nextInt((9999 - 1000) + 1) + 1000;
    }



    public int getId(){
        return this.id;
    }

    public  void setBirthDate(int year,int month,int day  ){
        this.birthDate = LocalDate.of(year, month, day);
    }

    public  void setDethDate(int year,int month,int day  ){
        this.dethDate = LocalDate.of(year, month, day);
    }

    public String toString(){
        if (dethDate==null ){
            return String.format("%s;  %s; %s; data rozhdenia: %s; (%s)",this.name,this.familiya,this.pol , this.birthDate, getVozrast() );
        }else{
            return String.format("%s;  %s; %s; data rozhdenia: %s; data smerty: %s; (%s)",this.name,this.familiya,this.pol , this.birthDate, this.dethDate, getVozrast() );
        }

    }

    public void addChildren(Human child ){
        if (!children.contains(child)){
            children.add(child);
            child.parents.add(this);
        }
        else{
            System.out.println("danniy chelovek uzhe dobavlen");
        }
    }

    public void addParents(Human parent ){
        parents.add(parent);
        parent.children.add(this);
    }



    @Override
    public List<Human>  getChildren(){
        return this.children;
    }

    public List<Human>  getParents(){
        return this.parents;
    }

    @Override
    public Human  getSuprug(){
        if (this.suprug==null ){
            return null;
        }else{
            return this.suprug;

        }

    }

    public void setAge(){
        LocalDate date= LocalDate.now();
        if (dethDate==null ){
            this.age=Period.between(birthDate, date).getYears();
        }else{
            this.age= Period.between(birthDate, dethDate).getYears();
        }
    }



    public String getVozrast(){
        return Integer.toString(age);
    }

    public void addSuprug(Human supr ){
        if (this.suprug==null && supr.suprug==null){
            this.suprug=supr;
            supr.suprug=this;
        }
        else{
            System.out.println("Uzhe v brake");
        }
    }

    @Override
    public LocalDate getBirtdayDate(){
        return this.birthDate;
    }


    private LocalDate setBirtdayDate(String birthDate) {

        DateTimeFormatter formatter;
        formatter= DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return LocalDate.parse(birthDate, formatter);
    }

    private LocalDate setdethDate(String dethDate) {

        DateTimeFormatter formatter;
        formatter= DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return LocalDate.parse(dethDate, formatter);
    }

    @Override
    public int getAge(){
        return this.age;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public String getFamilia(){
        return this.familiya;
    }

    @Override
    public Pol getPol(){
        return this.pol;
    }


    @Override
    public int compareTo(Human o){
        return this.name.compareTo(o.name);
    }



}