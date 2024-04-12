package Family_Tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.Period;

public class Human {
    private long id;
    private String name;
    private LocalDate birth;
    private LocalDate death;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;
    private Human partner;

    public Human(String name, LocalDate birth, LocalDate death, Gender gender, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birth = birth;
        this.death = death;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birth) {
        this(name, birth, null, gender, null, null);
    }

    public Human(String name, Gender gender, LocalDate birth,
                 Human father, Human mother) {
        this(name, birth, null, gender, father, mother);
    }

    public boolean addParents(Human parents){
        if (parents.getGender().equals(Gender.Female)) {
            setFather(parents);
        } else {
            setMother(parents);
        }
        return true;
    }
    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }
    public void setFather(Human father){
        this.father = father;
    }
    public void setMother(Human mother){
        this.father = mother;
    }
    public Object getGender() {return gender;}
    public Human getMother(){return mother;}

    public Human getFather(){return father;}

    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if(father != null){
            list.add(father);
        }
        if(mother != null){
            list.add(mother);
        }
        return list;
    }
    public List<Human> getChildren(){
        return children;
    }

    public int calculateAge(LocalDate birth, LocalDate currentDate) {
        return Period.between(birth, currentDate).getYears();
    }
    public int getAge() {
        if (null == death) {
            return calculateAge(birth, LocalDate.now());
        }else{
            return calculateAge(birth, death);
        }
    }

    public String getName(){
        return name;
    }
    public long getID(){
        return id;
    }
    public void setID(long id){this.id = id;}
    public LocalDate getBirth(){
        return birth;
    }
    public LocalDate getDeath(){
        return death;
    }
    public void setBirth(LocalDate birth){this.birth = birth;}
    public void setDeath(LocalDate death){this.death = death;}

    @Override
    public String toString(){return getInfo();}
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append("Имя: ");
        sb.append(name);
        sb.append("Возраст: ");
        sb.append(getAge());
        sb.append("Дети: ");
        sb.append(children);
        sb.append("Родители: ");
        sb.append(getFatherInf());
        sb.append(" , ");
        sb.append(getMotherInf());
        if (!(death == null)) {
            sb.append(getDeath());
        }
        return sb.toString();
    }

    public String getMotherInf() {
        String res = "Мама: ";
        Human mother = getMother();
        if (mother != null) {
            res += mother.getName();
        } else {
            res = "Неизвестна";
        }
        return res;
    }
    public String getFatherInf() {
        String res = "Отец: ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res = "Неизвестен";
        }
        return res;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }if(!(obj instanceof Human human)){
            return false;
        }
        return human.getID() == getID();
    }
}
