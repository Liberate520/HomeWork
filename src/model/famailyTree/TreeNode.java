package model.famailyTree;

import java.time.LocalDate;
import java.util.List;

public interface TreeNode<T> {
   void setId(long id);
   long getId();
   T getFather();
   T getMother();
   boolean addChild(T human);
   boolean addParent(T human);
   String getName();
   LocalDate getDeathDate();
   LocalDate getBirthDate();
   List<T> getChildren();
   T getSpouse();
   void setSpouse(T human);
}
