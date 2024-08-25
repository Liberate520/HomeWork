package my_fam_tree.treeService;

import my_fam_tree.model.Human;

import java.util.List;

public interface IPlant {
    List<Human> getChildren(String name);
    Human[] getParents(String name);
    List<Human> getSiblings(String name);
}
