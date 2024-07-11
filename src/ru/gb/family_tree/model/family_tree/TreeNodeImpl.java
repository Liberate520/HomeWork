package ru.gb.family_tree.model.family_tree;

import ru.gb.family_tree.model.humen.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TreeNodeImpl implements TreeNode<TreeNodeImpl> {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private TreeNodeImpl father;
    private TreeNodeImpl mother;
    private List<TreeNodeImpl> parents;
    private List<TreeNodeImpl> children;

    public TreeNodeImpl(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, TreeNodeImpl father, TreeNodeImpl mother) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.father = father;
        this.mother = mother;
        this.parents = new ArrayList<>();
        if (father != null) this.parents.add(father);
        if (mother != null) this.parents.add(mother);
        this.children = new ArrayList<>();
    }

    public TreeNodeImpl(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null);
    }

    public TreeNodeImpl(String name) {
        this(name, null, null, null, null, null);
    }

    public TreeNodeImpl(String motherName, Object o, Object o1, Object o2) {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id)
                .append(", Имя: ").append(name)
                .append(", Пол: ").append(gender)
                .append(", Дата рождения: ").append(birthDate)
                .append(", Дата смерти: ").append(deathDate)
                .append(", Родители: [");
        for (TreeNodeImpl parent : parents) {
            sb.append(parent.getName()).append(" ");
        }
        sb.append("], Дети: [");
        for (TreeNodeImpl child : children) {
            sb.append(child.getName()).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public List<TreeNodeImpl> getParents() {
        return parents;
    }

    @Override
    public List<TreeNodeImpl> getChildrens() {
        return children;
    }

    @Override
    public void addParent(TreeNodeImpl parent) {
        this.parents.add(parent);
    }

    @Override
    public void addChild(TreeNodeImpl child) {
        this.children.add(child);
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

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }
}
