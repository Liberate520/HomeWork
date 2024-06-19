package lv.homeWork.model;

import lv.homeWork.model.objects.Human;
import lv.homeWork.model.GenerationCalculator;

import java.util.ArrayList;
import java.util.List;

public class ObjectRelations {

    private List<Human> parents;
    private List<Human> childrens;
    private Human married;

    public ObjectRelations() {
        parents = new ArrayList<>();
        childrens = new ArrayList<>();
        married = null;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildrens() {
        return childrens;
    }

    public void addChild(Human child) {
        if (child != null) {
            childrens.add(child);
            child.getObjectRelations().addParent(child);
            GenerationCalculator.setGeneration(child);
        }
    }

    public void addParent(Human parent) {
        if (parent != null) {
            parents.add(parent);
        }
    }

    public Human getFather() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Male) {
                return parent;
            }
        }
        return null;
    }

    public Human getMother() {
        for (Human parent : parents) {
            if (parent.getGender() == Gender.Female) {
                return parent;
            }
        }
        return null;
    }

    public void setMarried(Human spouse) {
        this.married = spouse;
        if (spouse != null && spouse.getObjectRelations().getMarried() != married) {
            spouse.getObjectRelations().setMarried(this.married);
        }
    }

    public Human getMarried() {
        return married;
    }
}
