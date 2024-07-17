package Model.family_tree.human;

import java.util.ArrayList;
import java.util.List;

public class Сommunications {
    private Human human;
    private List<Human> children;
    private Human father;
    private Human mother;
    private Human spouse;


    public Сommunications(Human human) {
        this.human = human;
        children = new ArrayList<>();
        this.father = father;
        this.mother = mother;


    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {

        this.mother = mother;
    }

    public boolean addParent(Human parent) {
        if (parent.getSex().equals(Gender.Male)) {
            setFather(parent);
        } else if (parent.getSex().equals(Gender.Female)) {
            setMother(parent);
        }
        return true;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }


    public List<Human> getParents() {
        {
            List<Human> list = new ArrayList<>(2);
            if (father != null) {
                list.add(father);
            }
            if (mother != null) {
                list.add(mother);
            }
            return list;
        }
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {

        return spouse;
    }

    public List<Human> getChildren() {

        return children;
    }


}
