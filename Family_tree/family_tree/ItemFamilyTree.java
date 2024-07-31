package Family_tree.family_tree;

import java.util.List;

import Family_tree.human.Human;

public interface ItemFamilyTree {
    String getName();
    int getAge();
    void setId(long l);
    Object getSpouse();
    Object getFather();
    Object getMother();
    void setSpouse(Object object);
    List<Human> getChildren();
    Human addChild();
}
