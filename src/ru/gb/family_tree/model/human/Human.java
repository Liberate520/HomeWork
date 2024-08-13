package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.familly_tree.ItemFamilyTree;
import ru.gb.family_tree.model.familly_tree.TreeNode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Human implements TreeNode<Human>, ItemFamilyTree{
    private long id;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Human father, mother, spouse;
    private List<Human> children;  // не очень понимаю зачем этот список, если его можно получить из мамы и папы

    public Human(String name,  Gender gender, LocalDate birthDate) { // Общий конструктор для Человека
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        children = new ArrayList<>();
    }

    public void setId(long id) { this.id = id; }
    public long getId() { return id; }

    public void setName(String name) { this.name = name;}
    public String getName() {return name; }

    @Override
    public LocalDate getBirthDay() {
        return null;
    }

    @Override
    public LocalDate getDeathDay() {
        return null;
    }

    @Override
    public List<Human> getParents() {
        return List.of();
    }

    public void setGender(Gender gender){ this.gender = gender;}
    public Gender getGender () { return gender; }

    public void setBirthDate(LocalDate birthDate) {this.birthDate = birthDate;}
    public LocalDate getBirthDate() {return birthDate;}

    public void setDeathDate(LocalDate deathDate) {this.deathDate = deathDate;}
    public LocalDate getDeathDate() {return deathDate;}

    public void setFather(Human father) {this.father = father;}
    public Human getFather() {return father;}

    public void setMother(Human mother) {this.mother = mother;}
    public Human getMother() {return mother;}

    @Override
    public boolean addChild(Human human) {
        return false;
    }

    @Override
    public boolean addParent(Human human) {
        return false;
    }

    public void setSpouse(Human spouse) {this.spouse = spouse;}
    public Human getSpouse() {return spouse;}

    public void setChildren(List<Human> children) {this.children = children;}
    public List<Human> getChildren() {return children;}

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id=");
        sb.append(id);
        sb.append(", имя=");
        sb.append(name);
        sb.append(", пол=");
        sb.append(getGender());
//        sb.append(", возраст=");
//        sb.append(getAge());
        sb.append(", ");
        sb.append(getSpouseInfo());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        return sb.toString();
    }

    private int getAge() {
        int age;
        age = (int) (System.currentTimeMillis() - getBirthDate().getYear());
        return age;
    }

    public String getSpouseInfo(){
        String res = "супруг(а): ";
        if (spouse == null) {
            res += "нет";
        } else {
            res += spouse.getName();
        }
        return res;
    }
    public String getMotherInfo(){
        String res = "мать: ";
        if (mother == null){
            res += "не учтено";
        } else {
            res += mother.getName();
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "отец: ";
        if (father == null){
            res += "не учтено";
        } else {
            res += father.getName();
        }
        return res;
    }


    @Override
    public String toString() {return getInfo();}
}



