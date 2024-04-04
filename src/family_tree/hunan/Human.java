package family_tree.hunan;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human {
    private long id;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Human mother;
    private Human father;
    private List<Human> children;
    private Human spouse;


    public Human (String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human mother, Human father){
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        children = new ArrayList<>();

    }

    public Human (String name, Gender gender, LocalDate birthDate){
        this(name, gender, birthDate, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human mother, Human father){
        this(name, gender, birthDate, null, mother, father);
    }

    public void setId(long id) { this.id = id; }
    public void setName(String name){
        this.name = name;
    }
    public void setBirthDate (LocalDate birthDate) { this.birthDate = birthDate; }
    public void setDeathDate (LocalDate deathDate) { this.deathDate = deathDate; }
    public void setGender (Gender gender){
        this.gender = gender;
    }
    public void setMother(Human mother){
        this.mother = mother;
    }
    public void setFather (Human father){
        this.father = father;
    }
    public void setSpouse(Human spouse){
        this.spouse = spouse;
    }

    public long getId() { return id;}
    public String getName(String name){ return name; }
    public LocalDate getBirthDate () { return birthDate; }
    public  LocalDate getDeathDate () { return deathDate; }
    public Human getMother(){ return mother;}
    public Human getFather(){ return father;}
    public Gender getGender(){ return gender;}
    public Human getSpouse(){ return spouse; }
    public List<Human> getChildren() { return children; }

    public boolean addChild(Human child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent (Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        } else {
            if (parent.getGender().equals(Gender.Female)) {
                setMother(parent);
            }
        }
        return true;
    }

    public List<Human> getParents(){
        List<Human> list = new ArrayList<>();
        if (father != null) {
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return  list;
    }

    public int getAge() {
        if (deathDate == null) {
            return  getPeriod (birthDate, LocalDate.now());
        }
        else {
            return getPeriod(birthDate, deathDate);
        }
    }

    private int cetPeriod (LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate,deathDate);
        return diff.getYears();
    }

    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder Sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя: ");
        sb.append(named);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", дата рождения: ");
        sb.append(birthDate);
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", супруг(а): ");
        sb.append(getSpouseInfo());
        sb.append(", мать: ");
        sb.append(getMotherInfo());
        sb.append(", отец: ");
        sb.append(getFatherInfo());
        sb.append(", дети: ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getSpouseInfo(){
        if (spouse == null){
            String res = "нет";
        }else {
            String res = spouse.getName();
        }
        return res;
    }
    public String getMotherInfo(){
        Human mother = getMother();
        if (mother != null){
            String res = mother.getName();
        }else {
            String res = "нет данных";
        }
        return res;
    }
    public String getFatherInfo(){
        Human father = getFather();
        if (father != null){
            String res = fatherr.getName();
        }else {
            String res = "нет данных";
        }
        return res;
    }
    public String getChildrenInfoo(){
        StringBuilder res = new StringBuilder();
        String res = null;
        if (!children.isEmpty()) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        }else {
            res.append("нет");
        }
        return res.toString();
    }


    @Override
    public boolean equals(Objects obj){
        if (this = obj) {
            return true;
        }
        if (obj instanceof Human human) {
            return human.getId() == getId();
        }
        return  false;
    }
}

