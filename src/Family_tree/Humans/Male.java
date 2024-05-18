package Family_tree.Humans;

import java.time.LocalDate;

import Family_tree.Gender;

public class Male extends Human {

    public Male(String name) {
        super(name, Gender.Male);        
    }
    public Male(String name, LocalDate bday){
        super(name, Gender.Male, bday);        
    }

    public void setMother(Female female){
        this.mother = female;
    }    
    public void setFather(Male male){
        this.father = male; 
    }    
    public void addPartner(Female female){
        this.partners.add(female);
    }
    
}
