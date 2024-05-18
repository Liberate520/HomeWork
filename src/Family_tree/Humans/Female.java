package Family_tree.Humans;

import java.time.LocalDate;

import Family_tree.Gender;

public class Female extends Human{

    public Female(String name) {
        super(name, Gender.Female);       
    }
    public Female(String name, LocalDate bday){
        super(name, Gender.Female, bday);        
    }
    public void setMother(Female female){
        this.mother = female;
    }    
    public void setFather(Male male){
        this.father = male; 
    }

    public void addPartner(Male male){
        this.partners.add(male);
    }
    
}
