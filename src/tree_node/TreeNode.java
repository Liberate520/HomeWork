package tree_node;


import human.Human;

import java.util.List;

public interface TreeNode<T extends TreeNode<T>> {
    String getName();
    void setName(String name);
    Human getParent();
    void setParent(Human parent);
    List<Human> getChildren();
    void addChild(Human child);
}
