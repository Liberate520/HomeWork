package human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human  {
    private  long id;
    private String name;
    private Gender gender;
    private LocalDate brithDate, deathDate;

    private Human mother, father;
    private List<Human> children;
   // private Human spouse;

    public Human(String name, Gender gender, LocalDate brithDate, LocalDate deathDate, Human mother, Human father) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.brithDate = brithDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate brithDate) {
        this(name,gender,brithDate,null,null,null);
    }
    public Human(String name, Gender gender, LocalDate brithDate, Human mother, Human father){
        this(name,gender,brithDate,null,mother,father);}

    public boolean addChild(Human ciild) {
        if (!children.contains(ciild)) {
            children.add(ciild);
            return  true;
        }
        return false;
    }
    public boolean addParents (Human parent) {
        if (parent.getGender().equals(Gender.Male)){
            setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }return  true;
    }

    public String getClidrenInfo(){
        StringBuilder ch = new StringBuilder();
        ch.append("Дети: ");
        if (!children.isEmpty()) {
            ch.append(children.get(0).getName());
            for (int i=1; i < children.size(); i++) {
                ch.append(", "); ch.append(children.get(i).getName());
            }
        } else {ch.append(" детей нет");};
        return ch.toString();
    }

    public Gender getGender() {return gender;}

    public void setGender(Gender gender) {this.gender = gender;}

    public Human getMother() {return mother;}

    public void setMother(Human mother) {this.mother = mother;}

    public Human getFather() {return father; }

    public void setFather(Human father) {this.father = father;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public long getId() { return id; }

    public void setId(long id) {this.id = id;}

    public List<Human> getChildren() {return children;}

    public void setChildren(List<Human> children) {this.children = children;}

    public LocalDate getBrithDate() {return brithDate;}

    public void setBrithDate(LocalDate brithDate) {this.brithDate = brithDate; }

    public LocalDate getDeathDate() {return deathDate; }

    public void setDeathDate(LocalDate deathDate) {this.deathDate = deathDate;}


    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if (father != null) {list.add(father);}
        if (mother !=null) {list.add(mother);}
        return list;
    }
public String getMotherInfo(){
        String rez = "мать ";
        Human mother = getMother();
        if (mother !=  null) {
            rez += mother.getName();
        } else {
            rez  = " не известна";
        }
        return rez;
}
    public String getFatherInfo(){
        String rez = "отец ";
        Human father = getFather();
        if (father !=  null) {
            rez += father.getName();
        } else {
            rez  = " не известен";
        }
        return rez;
    }

    @Override
    public String toString() { return getInfo(); }


    public String getInfo(){
        StringBuilder  sb = new StringBuilder();
        sb.append("ID: "); sb.append(id);
        sb.append(" , имя: "); sb.append(name);
        sb.append(" Период жизни: "); sb.append(brithDate);
        sb.append(" - "); sb.append(deathDate);
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", "); sb.append(getClidrenInfo());

        return sb.toString();
    }
}
