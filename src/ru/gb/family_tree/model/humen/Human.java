package ru.gb.family_tree.model.humen;

import ru.gb.family_tree.model.family_tree.TreeNodeImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human extends TreeNodeImpl {
    private List<TreeNodeImpl> parents;
    private List<TreeNodeImpl> childrens;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, TreeNodeImpl father, TreeNodeImpl mother) {
        super(name, gender, birthDate, deathDate, father, mother);
        this.parents = new ArrayList<>();
        if (father != null) {
            this.parents.add(father);
        }
        if (mother != null) {
            this.parents.add(mother);
        }
        this.childrens = new ArrayList<>();
    }

    public Human(String name) {
        super(name);
        this.parents = new ArrayList<>();
        this.childrens = new ArrayList<>();
    }

    @Override
    public List<TreeNodeImpl> getParents() {
        return parents;
    }

    @Override
    public List<TreeNodeImpl> getChildrens() {
        return childrens;
    }

    @Override
    public void addParent(TreeNodeImpl parent) {
        this.parents.add(parent);
    }

    @Override
    public void addChild(TreeNodeImpl child) {
        this.childrens.add(child);
    }
}
