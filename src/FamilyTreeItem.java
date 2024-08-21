import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Serializable {
    LocalDate getBirthDate();
    String getName();
    boolean addParent(T parent);
    boolean addChild(T child);
    List<T> getParents();
    void setId(long id);
    List<T> getChildren();
    long getId();
}
