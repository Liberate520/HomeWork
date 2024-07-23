package model.services;

public interface FamilyTreeService {
    void addPerson(String name, String birthDate, String genderStr, Integer fatherId, Integer motherId);
    String showTree();
    void sortByName();
    void sortByBirthDate();
    void saveTree(String filename);
    void loadTree(String filename);
}
