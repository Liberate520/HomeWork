package Family_tree.Humans;

public class Link {
    private LinkType type;
    private Male male;
    private Female female;
    private boolean isActual;

    public Link(LinkType type, Male male, Female female, boolean isActual){
        this.type = type;
        this.female = female;
        this.male = male;
        this.isActual = isActual;
    }
    public Link(LinkType type, Male male, Female female){
        this(type, male, female, true);
    }

    public LinkType getType(){
        return this.type;
    }
    public Male getMale(){
        return this.male;
    }
    public Female getFemale(){
        return this.female;
    }
    public boolean getActuality(){
        return this.isActual;
    }
    public void setType(LinkType value){
        this.type = value;
    }
    public void setMale(Male value){
        this.male = value;
    }
    public void setFemale(Female value){
        this.female = value;
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
