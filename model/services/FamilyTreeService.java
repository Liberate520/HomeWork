package model.services;

public interface FamilyTreeService<T> {
    void addPerson(String name, String birthDate, String genderStr, Integer fatherId, Integer motherId); // SRP: изменен метод для добавления человека
    String showTree();
    void sortByName();
    void sortByBirthDate();
    void saveTree(String filename);
    void loadTree(String filename);
}
