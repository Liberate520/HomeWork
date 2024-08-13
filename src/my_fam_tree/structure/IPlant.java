package my_fam_tree.structure;

import java.util.List;

public interface IPlant {
    List<Human> getChildren(String name);
    Human[] getParents(String name);
    List<Human> getSiblings(String name);
}
