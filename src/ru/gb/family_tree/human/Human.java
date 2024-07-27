package ru.gb.family_tree.human;

import ru.gb.family_tree.family_tree.TreeNode; // Импортируем TreeNode
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements TreeNode<Human> {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> parents = new ArrayList<>();
    private List<Human> children = new ArrayList<>();

    // конструктор
    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        parents = new ArrayList<>();
        children = new ArrayList<>();
        if (father != null){
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }

    }

    public Human(String name, Gender gender, LocalDate birthDate){
        this(name, gender, birthDate, null, null, null);
    }

    public boolean addChild(Human child){
        if (!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent){
        if (!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return  false;
    }

    public Human getFather(){
        for (Human parent: parents){
            if (parent.getGender() == Gender.Male){
                return parent;
            }
        }
        return null;
    }

    public Human getMother(){
        for (Human parent: parents){
            if (parent.getGender() == Gender.Female){
                return parent;
            }
        }
        return null;
    }

    public int getAge(){
        if (deathDate == null){
            return  getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public String getName() { return  name; }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public LocalDate getBirthDate() { return birthDate; }

    public LocalDate getDeathDate() { return deathDate; }

    public List<Human> getParents() { return parents; }

    public List<Human> getChildren() { return children; }

    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public void setDeathDate(LocalDate deathDate) { this.deathDate = deathDate; }

    public Gender getGender() { return  gender; }

    @Override
    public String toString(){
        return getInfo();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", имя человека: ");
        sb.append(name);
        sb.append(" - возраст человека - лет: ");
        sb.append(getAge());
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    public String getMotherInfo(){
        String res = " мама: ";
        Human mother = getMother();
        if (mother != null){
            res += mother.getName();
        } else{
            res += "неизвстна";
        }
        return  res;
    }

    public String getFatherInfo(){
        String res = " папа: ";
        Human father = getFather();
        if (father != null){
            res += father.getName();
        } else{
            res += "неизвстна";
        }
        return  res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (children.size() != 0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++){
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("нет");
        }
        return res.toString();
    }
}
