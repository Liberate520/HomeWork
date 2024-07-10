package familytree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class FamilyMember implements Serializable {
    private String name;
    private List<FamilyMember> children;
    private List<FamilyMember> parents;

    public FamilyMember(String name) {
        this.name = name;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<FamilyMember> getChildren() {
        return children;
    }

    public void addChild(FamilyMember child) {
        this.children.add(child);
        child.addParent(this);
    }

    public List<FamilyMember> getParents() {
        return parents;
    }

    public void addParent(FamilyMember parent) {
        this.parents.add(parent);
    }
}