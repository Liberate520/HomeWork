package Human;






import java.time.*;
import java.util.*;

import Pol.Pol;

import java.time.format.DateTimeFormatter;

public class Human implements Comparable<Human>, FamilyTreeItem <Human> {
    private String name;
    private String familiya;
    private Pol pol;
    private Human suprug;
    private LocalDate birthDate, dethDate;
    private List <Human> parents;
    private List <Human> children;
    private int age;
    
    
    public Human( String name, String familiya, String pol, String birthDate, String dethDate ){
       
        this.name= name;
        this.familiya=familiya;
        if (pol.equals("man")){
            this.pol = Pol.valueOf("man");
        }else if (pol.equals("woman")){
            this.pol = Pol.valueOf("woman");
        }else{
            System.out.println("vvedite pol: man ili woman");
        }
        
        this.children= new ArrayList<>();
        this.parents= new ArrayList<>();
        
            
        this.birthDate=getBirtdayDate(birthDate);
        
        
        if (dethDate != null && !dethDate.equals("")){
            
            this.dethDate=getdethDate(dethDate);
        }
            
        
    }
    
    

    



    public Human( String name, String familiya, String pol, String birthDate  ){
        this (name,  familiya,  pol, birthDate,  null);
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
       }
       else{
           System.out.println("danniy chelovek uzhe dobavlen");
       }
   }
   
   public void setParents(Human parent ){
       parents.add(parent);
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
       return this.suprug;
   }
   
    public String getVozrast(){
        LocalDate date= LocalDate.now();
        if (dethDate==null ){
                this.age=Period.between(birthDate, date).getYears();
                return Integer.toString(Period.between(birthDate, date).getYears());
   
        }else{
           return Integer.toString(Period.between(birthDate, dethDate).getYears());
        }   
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

    private LocalDate getBirtdayDate(String birthDate) {
        
        DateTimeFormatter formatter;
        formatter= DateTimeFormatter.ofPattern("yyyy.MM.dd");
        return LocalDate.parse(birthDate, formatter);
    }

    private LocalDate getdethDate(String dethDate) {
        
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
    public int compareTo(Human o){
        return this.name.compareTo(o.name);
    }
 


}


