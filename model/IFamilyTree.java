package model;

import java.util.List;

public interface IFamilyTree<T extends Person> {
    void addMember(T person);
    T getMemberById(int id);
    List<T> getMembers();
    String toString();
}
