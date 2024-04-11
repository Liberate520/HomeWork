import java.util.ArrayList;
import java.util.List;

class Children {
    private String name;
    private List<Children> siblings;
    private List<Children> parents;

    public Children(String name) {
        this.name = name;
        this.siblings = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Children> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<Children> siblings) {
        this.siblings = siblings;
    }

    public List<Children> getParents() {
        return parents;
    }

    public void setParents(List<Children> parents) {
        this.parents = parents;
    }

    public void addSibling(Children sibling) {
        siblings.add(sibling);
    }

    public void removeSibling(Children sibling) {
        siblings.remove(sibling);
    }

    public void addParent(Children parent) {
        parents.add(parent);
    }

    public void removeParent(Children parent) {
        parents.remove(parent);
    }
}
