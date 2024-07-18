package family_tree.model.human;

import family_tree.model.family_tree1.ItemFamilyTree;
import java.util.List;

public interface Person extends ItemFamilyTree {
    List<Person> getChildren();
    void setFather(Person father);
    void setMother(Person mother);
}
