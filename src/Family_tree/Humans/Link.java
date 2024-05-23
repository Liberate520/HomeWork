package Family_tree.Humans;

public class Link {
    private LinkType type;
    private Human male;
    private Human female;
    private boolean isActual;

    public Link(LinkType type, Human male, Human female, boolean isActual){
        this.type = type;
        this.female = female;
        this.male = male;
        this.isActual = isActual;
    }
    public Link(LinkType type, Human male, Human female){
        this(type, male, female, true);
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
        sb.append(" and ");
        sb.append(this.female.toString());
        sb.append(" are ");
        sb.append(this.type.toString());
        return sb.toString();
    }


}
