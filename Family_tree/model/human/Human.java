package Family_tree.model.human;

// import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import Family_tree.model.family_tree.ItemFamilyTree;

public class Human implements ItemFamilyTree<Human>, Comparable<Human> {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Human father;
    private Human mother;
    private List<Human> children;
    // private List<Human> parents;
    private Human spouse;

    public Human(long id, String name, Gender gender, LocalDate dateOfBirth,
            LocalDate dateOfDeath, Human spouse, Human father, Human mother) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.spouse = spouse;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
        // parents = new ArrayList<>();
    }

    public Human(long id, String name, Gender gender, LocalDate dateOfBirth) {
        this(id, name, gender, dateOfBirth, null, null, null, null);
    }

    public Human(long id, String name, Gender gender, LocalDate dateOfBirth, Human father, Human mother) {
        this(id, name, gender, dateOfBirth, null, null, father, mother);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    // public List<Human> getParents() {
    //     return parents;
    // }

    // public void setParents(List<Human> parents) {
    //     this.parents = parents;
    // }

    public int getAge() {
        LocalDate endDate = dateOfDeath != null ? dateOfDeath : LocalDate.now();
        Period period = Period.between(dateOfBirth, endDate);
        return period.getYears();
    }
    

    public void addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            if (this.getGender() == Gender.Male) {
                child.addFather(this);
                if (child.getMother() == null){
                    child.setMother((this.getSpouse()));
                }
            } else {
            child.addMother(this);
            if (child.getFather() == null){
                child.setFather((this.getSpouse()));
            }
            }
        }
    }

    public void addMother(Human parent) {
        if (parent.getGender().equals(Gender.Female) ) {
            setMother(parent);
            if (this.getFather() == null){
                this.setFather(parent.getSpouse());
            }
        } else {
            addFather(parent);
        }
        if (!parent.getChildren().contains(this)) {
            parent.getChildren().add(this); 
        }
    }

    public void addFather(Human human) {
        if (human.getGender().equals(Gender.Male) ) {
            setFather(human);
            if (this.getMother() == null){
                this.setMother(human.getSpouse());
            }
        } else {
            addMother(human);
        }
        if (!human.getChildren().contains(this)) {
            human.getChildren().add(this); 
        }
    }

    public void getMarried(Human human) {
        if (this.getSpouse() == null || this.getSpouse() == human && human.getSpouse() == null || human.getSpouse() == this) {
            human.setSpouse(this);
            this.setSpouse(human);
            this.setChildren(human.getChildren());
            human.setChildren(this.getChildren());
        }
    }

    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(", name: ");
        sb.append(name);
        sb.append(", Age: ");
        sb.append(getAge());
        sb.append(", gender: ");
        sb.append(getGender());
        sb.append(", spouse: ");
        sb.append(getSpouseInfo());
        sb.append(", children: ");
        sb.append(getChildrenInfo());
        sb.append(", father: ");
        sb.append(getFatherInfo());
        sb.append(", mother: ");
        sb.append(getMotherInfo());
    
        return sb.toString();
    }

    public String getSpouseInfo() {
        StringBuilder res = new StringBuilder();
        if (spouse != null) {
            res.append(spouse.getName());
        } else {
            res.append("no data");
        }
        return res.toString();
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("no data");
        }
        return res.toString();
    }

    public String getFatherInfo() {
        if (father != null) {
            return father.getName();
        } else {
            return "no data";
        }
    }
    
    public String getMotherInfo() {
        if (mother != null) {
            return mother.getName();
        } else {
            return "no data";
        }
    }

    @Override
    public int compareTo(Human anotherHuman) {
        return this.name.compareTo(anotherHuman.name);
    }
}
