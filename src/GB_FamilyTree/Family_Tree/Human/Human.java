package GB_FamilyTree.Family_Tree.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {  // Добавлено implements Serializable
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private Human mother;
    private Human father;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null);
    }

    public void setGender(Gender gender) { this.gender = gender; }

    public void setName(String name) { this.name = name; }

    public void setMother(Human mother) { this.mother = mother; }

    public void setFather(Human father) { this.father = father; }

    public Human getMother() { return mother; }

    public Human getFather() { return father; }

    public Gender getGender() { return gender; }

    public String getName() { return name; }

    public List<Human> getChildren() { return children; }

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

    public boolean addChild(Human child) {
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return  getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        return sb.toString();
    }
}