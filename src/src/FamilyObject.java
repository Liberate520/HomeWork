package src;

import java.util.List;
public interface FamilyObject<E> {

    Integer getAge();
    String getName();
    List<E> getChildren();
    E getFather();
    E getMother();
    void setChild(E child);
    void getParent(E parent);
    StringBuilder getPersCard(E person);

}
