package family_tree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable ,Comparable<Human>{
    int id;
    private static int sumId=0; // чтобы id не повторялось
    private String name;
    private Human mother,father;
    private Human spouse;  //Супруг,супруга
    private List<Human> children=new ArrayList<>();
    private LocalDate birghDate,deathDate;
    private Gender gender;

    public Human() {
    }

    public Human(String name, LocalDate birghDate, LocalDate deathDate, Gender gender, int id) {
        this.name = name;
        this.birghDate = birghDate;
        this.deathDate=deathDate;
        this.gender = gender;
        this.id=id;
//        sumId++;
//        id=sumId;
    }
    public Human(String name, LocalDate birghDate, Gender gender,int id){  //перегрузка конструктора
        this(name,birghDate,null,gender,id);
    }
    public void addChild(Human child){  //добавить ребёнка
        if (!children.contains(child))
           children.add(child);
    }
    public void addMother(Human mother) {  //добавить мать
        if (mother!=null) {
            if (this.mother==null)
                this.mother = mother;
        }
    }
    public void addFather(Human father){   //добавить отца
        if (father!=null) {
            if (this.father==null)
             this.father = father;
        }
    }
    public void addSpouse(Human spouse){   //добавить супруга,супругу
        if (spouse!=null) {
            if (this.spouse==null)
             this.spouse = spouse;
        }
    }

    public int getAge(){  //возвращает возраст либо годы жизни
        if (deathDate==null){
            return Period.between(birghDate,LocalDate.now()).getYears();//метод возвращает разницу в годах между двумя датами
        }
        else  return Period.between(birghDate,deathDate).getYears();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Human getSpouse() {
        return spouse;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getNameSpouse() {
        if (spouse!=null)
        return spouse.name;
        else return null;
    }
    public String getNameMother() {
        if (mother!=null)
        return mother.name;
        else return null;
    }

    public String getNameFather() {
        if (father!=null)
        return father.name;
        else return null;
    }
    public List<String> getNameChildren() {
        List<String> list=new ArrayList<>();
        children.forEach((ch)->list.add(ch.name));
        return list;
    }

    public LocalDate getBirghDate() {
        return birghDate;
    }

    @Override
    public String toString() { //метод доработан
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", spouse=" + getNameSpouse() +
                ", mother=" + getNameMother() +
                ", father=" + getNameFather() +
                ", children=" + getNameChildren() +
                ", birghDate=" + birghDate +
                ", deathDate=" + deathDate +
                ", gender=" + gender +
                '}';
    }

    @Override
    public int compareTo(Human h) {
        return name.compareTo(h.getName());
    }
}
