package family_tree.model.humanTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface ItemHumanTree<E> extends Serializable {
    String getName();
    LocalDate getDob();
    E getMother();
    E getFather();
    String getSurname();
    List<E> getChildren();
}
