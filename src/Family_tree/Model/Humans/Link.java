package Family_tree.Model.Humans;

import java.io.Serializable;
import java.time.LocalDate;

public class Link implements Serializable{
    private LinkType type;
    private Human male;
    private Human female;
    private boolean isActual;
    private LocalDate start;
    private LocalDate finish;

    public Link(LinkType type, Human male, Human female, boolean isActual, LocalDate start, LocalDate finish){
        this.type = type;
        this.female = female;
        this.male = male;
        this.isActual = isActual;
        this.start = start;
        this.finish = finish;
    }
    public Link(LinkType type, Human male, Human female){
        this(type, male, female, true, null, null);
    }

    public LinkType getType(){
        return this.type;
    }
    public Human getMale(){
        return this.male;
    }
    public Human getFemale(){
        return this.female;
    }
    public boolean getActuality(){
        return this.isActual;
    }
    public void setType(LinkType value){
        this.type = value;
    }
    public void setMale(Human value){
        if (value.getGender() == Gender.Male){
            this.male = value;
        }        
    }
    public void setFemale(Human value){
        if (value.getGender() == Gender.Male){
            this.female = value;
        }  
    }
    public void setActuality(boolean value){
        this.isActual = value;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.male.toString());
        sb.append(" и ");
        sb.append(this.female.toString());
        if (this.finish == null){
            sb.append(" являются "); 
            sb.append(this.type.toString());           
        } else {
            sb.append(" были ");
            sb.append(this.type.toString());
            sb.append(" с ");
            sb.append(this.start);
            sb.append(" до ");
            sb.append(this.finish);
        }        
        return sb.toString();
    }

    public LocalDate getStartDate(){
        return this.start;
    }
    public LocalDate getFinishDate(){
        return this.finish;
    }
    public void setStartDate(LocalDate start){
        this.start = start;
    }
    public void setFinishDate(LocalDate finish){
        this.finish = finish;
    }


}
