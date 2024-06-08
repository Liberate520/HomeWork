package Family.pack.Family_Tree;

import java.util.List;

public interface FamilyTreeItem<T> extends Comparable<T> {
    double getAge();
    String getName();
    List<T> getChildren();
    String getInfo();


}
