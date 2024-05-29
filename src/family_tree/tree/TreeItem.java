package family_tree.tree;

import java.util.Date;

public interface TreeItem<T> extends Comparable<T> {
    String getName();
    int getAge();
    Date getBirthDate();
    Date getDeathDate();
}
