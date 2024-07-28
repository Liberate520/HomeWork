package Model.FamilyTree;

import java.util.List;

public interface FamilyMember<T extends FamilyMember<T>> {

    List<T> getChildrensList();

    void addParentstoFamilyMember(T parent);

    List<T> getParentsofFamilyMember();

    void addChildrentoFamilyMember(T child);

    Integer getId();
    String getName();

    void setSpouse(T spouse);
    T getSpouse();
}
