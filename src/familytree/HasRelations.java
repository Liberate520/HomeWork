package familytree;

import java.util.List;

public interface HasRelations<T> {
    List<T> getChildren();
    List<T> getParents();
}

