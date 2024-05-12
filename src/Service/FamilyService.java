package Service;

import Model.FamilyTree;
import Model.FileHandler;
import Model.Human;
import Model.Gender;
import java.time.LocalDate;

public interface FamilyService {
    void addHuman(String name, LocalDate dob, Gender gender);
    void addFather(String childName, String fatherName, LocalDate dob, Gender gender);
    void addMother(String childName, String motherName, LocalDate dob, Gender gender);
    void printFamilyTree();
    void saveTree(String filePath);
    void loadTree(String filePath);
}
