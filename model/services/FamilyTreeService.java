package model.services;

public interface FamilyTreeService<T> {
    void addPerson(T person, Integer fatherId, Integer motherId);
    String showTree();
    void sortByName();
    void sortByBirthDate();
}
