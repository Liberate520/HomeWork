package family_tree;

import family_tree.family_tree.TreeNode;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements TreeNode<Human>, Serializable, Comparable<Human> {


    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> parents;
    private List<Human> children;
    private Human mother;
    private Human father;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate,
                  List<Human> children, Human mother, Human father) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.parents = parents;
        this.children = new ArrayList<>();
        this.mother = mother;
        this.father = father;
    }



    public long getId() {
        return id;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Gender getGender() {
        return gender;
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        if (parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        }
        return true;
    }

    public List<Human> getParents() {
        List<Human> list = new ArrayList<>(2);
        if (father != null) {
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return list;
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }


    public List<Human> getChildren() {
        return children;
    }


    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }


    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        if (deathDate == null) {
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(" id: ").append(id);
        sb.append(" name: ").append(getName());
        sb.append(" gender: ").append(getGender());
        sb.append(" age: ").append(getAge());
        sb.append(" mother: ").append(getMotherInfo());
        sb.append(" father: ").append(getFatherInfo());
        sb.append(" children: ").append(getChildrenInfo());


        return sb.toString();
    }

    public String getMotherInfo() {
        String res = "mother ";
        Human mother = getMother();
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "null";
        }
        return res;
    }

    public String getFatherInfo() {
        String res = "father ";
        Human father = getFather();
        if (father != null) {
            res += father.getName();
        } else {
            res += "null";
        }
        return res;
    }


    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append(" ");
        if (!children.isEmpty()) {
            for (Human child : children) {
                res.append(child.getName());
                res.append(" ");
            }
        } else {res.append("null");}
        return res.toString();

    }


    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}