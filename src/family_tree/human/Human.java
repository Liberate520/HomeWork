package family_tree.human;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private long id;
    private String name;
    private LocalDate dayOfBirth;
    private LocalDate dayOfDeath;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;
    private Human spouse;

    public Human(String name, LocalDate dayOfBirth,
                 LocalDate dayOfDeath, Gender gender,
                 Human father, Human mother) {
        id = -1;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.dayOfDeath = dayOfDeath;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public Human(String name, LocalDate dayOfBirth, Gender gender, Human father, Human mother){
        this(name, dayOfBirth, null, gender, father, mother);
    }

    public Human(String name, LocalDate dayOfBirth, Gender gender){
        this(name, dayOfBirth, null, gender, null, null);
    }

    public Human getSpouse() {return spouse; }

    public void setSpouse(Human spouse) {this.spouse = spouse; }

    public long getId() {return id; }

    public void setId(long id) {this.id = id;}

    public String getName() {return name; }

    public LocalDate getDayOfBirth() {return dayOfBirth;}

    public void setDayOfBirth(LocalDate dayOfBirth) {this.dayOfBirth = dayOfBirth;}

    public LocalDate getDayOfDeath() {return dayOfDeath;}

    public void setDayOfDeath(LocalDate dayOfDeath) {this.dayOfDeath = dayOfDeath;}

    public Gender getGender() {return gender;}

    public Human getFather() {return father;}

    public void setFather(Human father) {this.father = father;}

    public Human getMother() {return mother;}

    public void setMother(Human mother) {this.mother = mother;
    }

    public List<Human> getChildren() { return children; }

    public boolean addChild(Human child){
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        }
        if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return true;
    }

    public List<Human> getParents(){
        List<Human> list = new ArrayList<>(2);
        if (father != null){
            list.add(father);
        }
        if (mother != null){
            list.add(mother);
        }
        return list;
    }

    public int getAge(){
        if (dayOfDeath == null){
            return getPeriod(dayOfBirth, LocalDate.now());
        } else{
            return getPeriod(dayOfBirth, dayOfDeath);
        }
    }

    private int getPeriod(LocalDate dayOfBirth, LocalDate dayOfDeath){
        Period diff = Period.between(dayOfBirth, dayOfDeath);
        return diff.getYears();
    }

    public String getSpouseInfo(){
        String res = "Супруг(а): '";
        if (spouse == null){
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }

    public String getMotherInfo(){
        String res = "Имя матери: ";
        Human mother = getMother();
        if (mother != null){
            res += mother.getName();
        } else {
            res += "неизвестно";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "Имя отца: ";
        Human father = getMother();
        if (father != null) {
            res += father.getName();
        } else {
            res += "неизвестно";
        }
        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("Дети: ");
        if (children.isEmpty()) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++){
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ");
        sb.append(id);
        sb.append('\n');
        sb.append("Имя: ");
        sb.append(name);
        sb.append('\n');
        sb.append("Дата рождения: ");
        sb.append(dayOfBirth);
        sb.append('\n');
        if (dayOfDeath != null) {
            sb.append("Дата смерти: ");
            sb.append(dayOfDeath);
            sb.append('\n');
        }
        if (gender != null) {
            sb.append("Пол: ");
            sb.append(gender);
            sb.append('\n');
        }
        if (father != null) {
            sb.append(getFatherInfo());
            sb.append('\n');
        }
        if (mother != null) {
            sb.append(getMotherInfo());
            sb.append('\n');
        }
        if (!children.isEmpty()) {
            sb.append(getChildrenInfo());
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof Human))
            return false;
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}