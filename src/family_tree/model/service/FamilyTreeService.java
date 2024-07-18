package family_tree.model.service;

import family_tree.model.human.Person;
import family_tree.model.human.Gender;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeService {
    Person addHuman(String name, LocalDate dob, Gender gender);
    void setParents(int childId, Integer fatherId, Integer motherId);
    List<Person> findHumansByName(String name);
    Person findHumanById(int id);
    String getHumanListInfo();
    void sortByName();
    void sortByDateBirth();
    void finish();

}
