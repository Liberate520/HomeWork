package family_tree;

import man.Gender;
import man.Man;

import java.util.List;

public interface FamilyTreeItem <E> {
    String getName();
    int getAge();
    long getId();
    void setId(long id);
    List<E> getParents();
    boolean addChild(Object child);
    List<E> getChildrens();
    Gender getGender();
    boolean addMother(E mother);
    boolean addFather(E father);


}
