package family_tree.human;

import family_tree.family_tree.TreeNode;

import java.time.LocalDate;
import java.util.List;

public class Human implements TreeNode<Human>, Comparable<Human> {
    private String name;
    private LocalDate dob, dod;
    private Gender gender;
    private List<Human> children;
    private Human mother, father;

    public Human(String name, LocalDate dob, Gender gender) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dob;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getFather() {
        return father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getMother() {
        return mother;
    }

    public void setDateOfDeath(LocalDate dod) {
        this.dod = dod;
    }

    public LocalDate getDateOfDeath() {
        return dod;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Gender getGender() {
        return gender;
    }

    // Методы интерфейса TreeNode

    @Override
    public void setId(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    @Override
    public long getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    @Override
    public boolean addChild(Human node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addChild'");
    }

    @Override
    public boolean addParent(Human node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addParent'");
    }

    @Override
    public LocalDate getDeathDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDeathDate'");
    }

    @Override
    public LocalDate getBirthDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBirthDate'");
    }

    @Override
    public List<Human> getParents() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getParents'");
    }

    @Override
    public Human getSpouse() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSpouse'");
    }

    @Override
    public void setSpouse(Human node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setSpouse'");
    }
}
