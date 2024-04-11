import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private String name;
    private List<TreeNode> children;
    private List<TreeNode> parents;

    public TreeNode(String name) {
        this.name = name;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public List<TreeNode> getParents() {
        return parents;
    }

    public void setParents(List<TreeNode> parents) {
        this.parents = parents;
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public void addParent(TreeNode parent) {
        parents.add(parent);
    }

    public void removeChild(TreeNode child) {
        children.remove(child);
    }

    public void removeParent(TreeNode parent) {
        parents.remove(parent);
    }
}
