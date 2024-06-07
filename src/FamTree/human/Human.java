package FamTree.human;

import FamTree.Gender;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, Comparable<Human> {
    private long  id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> parents;
    private List<Human> children;
    private Human spouse;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        parents = new ArrayList<Human>();
        if (father != null){
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate ){
        this(name,gender,birthDate,null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother ){
        this(name,gender,birthDate,null, father, mother);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
            return true;
        }
        return false;
    }

    public Human getFather(){
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
    return null;
    }

    public Human getMother(){
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }

    public int  getAge(){
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return  getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public void setSpouse(Human spouse) {this.spouse = spouse;}

    public Human getSpouse() {
        return spouse;
    }

    public String getName() {return name;}

    public long getId() {return id;}

    public void setId(long id){ this.id = id;}

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public List<Human> getParents() {return parents;}

    public List<Human> getChildren() {return children;}

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender() {return gender;}

    @Override
    public String toString() { return getInfo();}

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: " );
        sb.append(id);
        sb.append(", Имя: " );
        sb.append(name);
        sb.append(", Пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getSpouseInfo(){
        String response = "супруга(а): ";
        if (spouse == null){
            response += "нет";
        } else {
            response += spouse.getName();
        }
        return response;
    }

    public String getMotherInfo(){
        String response = "мать: ";
        Human mother = getMother();
        if (mother != null){
            response += mother.getName();
        } else {
            response += "неизвестна";
        }
        return response;
    }

    public String getFatherInfo(){
        String response = "отец: ";
        Human father = getMother();
        if (father != null){
            response += father.getName();
        } else {
            response += "неизвестен";
        }
        return response;
    }

    public String getChildrenInfo(){
        StringBuilder response =  new StringBuilder();
        response.append("дети: ");
        if (!children.isEmpty()) {
            response.append(children.get(0).getName());
            for (int i =1; i < children.size(); i++){
                response.append(", ");
                response.append(children.get(i).getName());
            }
        } else {
            response.append("отсутствуют");
        }
        return response.toString();
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}
