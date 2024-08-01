package familiTree;

import java.io.Serializable;
import java.util.List;

public interface TreeNode<T> extends Serializable {

    long getId();

    void setId(long id);

    String getName();

    int getAge();

    T getFather();

    T getMother();

    boolean isParent(T human);

    T getSpouse();

    void setSpouse(T spouses);

    List<T> getChildren();

    T addChildren(T child);


}
