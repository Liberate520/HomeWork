package ru.gb.family_tree.model.family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class TreeNodeImpl implements TreeNode<TreeNodeImpl> {
    private long id;
    private String name;
    private String gender;
    private LocalDate birthDate;
    private TreeNodeImpl spouse;
    private List<TreeNodeImpl> parents = new ArrayList<>();
    private List<TreeNodeImpl> children = new ArrayList<>();

    public TreeNodeImpl(String name, String gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public TreeNodeImpl(String name, String gender, LocalDate birthDate, TreeNodeImpl father, TreeNodeImpl mother) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        if (father != null) {
            this.parents.add(father);
        }
        if (mother != null) {
            this.parents.add(mother);
        }
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public TreeNodeImpl getSpouse() {
        return spouse;
    }

    @Override
    public void setSpouse(TreeNodeImpl spouse) {
        this.spouse = spouse;
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

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return toString(new HashSet<>());
    }

    private String toString(Set<TreeNodeImpl> visited) {
        if (visited.contains(this)) {
            return ""; // Предотвращаем бесконечный цикл
        }
        visited.add(this);

        StringBuilder sb = new StringBuilder();
        sb.append("TreeNodeImpl{id=").append(id)
                .append(", name='").append(name).append('\'')
                .append(", gender='").append(gender).append('\'')
                .append(", birthDate=").append(birthDate);

        if (spouse != null) {
            sb.append(", spouse=").append(spouse.getName());
        }

        sb.append(", parents=[");
        for (TreeNodeImpl parent : parents) {
            sb.append(parent.getName()).append(", ");
        }
        sb.append("], children=[");
        for (TreeNodeImpl child : children) {
            sb.append(child.getName()).append(", ");
        }
        sb.append("]}");

        return sb.toString();
    }
}
