package humanTree;

import java.time.LocalDate;
import java.util.List;

public interface ItemHumanTree<E> {
    String getName();
    LocalDate getDob();
    E getMother();
    E getFather();
    String getSurname();
    List<? extends ItemHumanTree> getChildren();
}
