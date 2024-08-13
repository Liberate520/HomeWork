package family_tree.model.human;

import java.time.LocalDate;

public interface HumanServiceInterface {
    void addHuman(String surname, String name, String middleName, Gender gender, LocalDate birthDate, LocalDate deathDate);
    void sortByName();
    void sortByAge();
    String getFamilyTreeInfo();
    void addSpouse(long humanId1, long humanId2);
    void deleteSpouse(long humanId1, long humanId2);
    void setRelationship(long childId, long parentId);
    void save();
    void load();
}
