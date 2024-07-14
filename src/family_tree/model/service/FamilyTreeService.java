package family_tree.model.service;

import family_tree.model.human.Gender;
import family_tree.model.human.Human;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeService {
    Human addHuman(String name, LocalDate dob, Gender gender);
    void setParents(int childId, Integer fatherId, Integer motherId);
    List<Human> findHumansByName(String name);
    Human findHumanById(int id);
    String getHumanListInfo();
    void sortByName();
    void sortByDateBirth();
    void finish();

}
