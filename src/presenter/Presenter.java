package presenter;

import model.Gender;
import view.View;
import java.time.LocalDate;

public interface Presenter {
    void addHuman(String name, LocalDate dateOfBirth, Gender gender, String fatherName, LocalDate fatherBirthDate, String motherName, LocalDate motherBirthDate);
    void getHumanListInfo();
    void sortByAge();
    void sortByName();
    void findMemberByName(String name);
    void findMembersByBirthYear(int year);
    void saveFamilyTree();
    void loadFamilyTree();
}
