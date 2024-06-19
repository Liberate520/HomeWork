package Family_tree.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeTop<T> extends Serializable {
     void setId(long id);
     int getId();
     T getFather();
     T getMother();
     void addChild(T child);
     void addParent(T parent);
     String getName();
     LocalDate getBirthDate();
     LocalDate getDeathDate();
     List<T> getParents();
     List<T> getChildren();
     T getSpouse();
     void setSpouse(T human);

}
