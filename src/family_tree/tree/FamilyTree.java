package family_tree.tree;

import family_tree.person.Human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyTree {
    private Map<Integer, Human> familyTree; //Integer - generation

    public FamilyTree() {
        familyTree = new HashMap<>();
    }

    public void addPersonToFamily(Human person, Integer generation) {
        familyTree.put(generation, person);
    }

    public Human findHumanByName(String name) {
        for (Integer key : familyTree.keySet())
            if (familyTree.get(key).getName().equalsIgnoreCase(name)) {
                return familyTree.get(key);
            }
        System.out.println("Human with name: " + name + " is not found");
        return null;

    }

    /**
     * @param dob (LocalDate)
     * @return first human with this date of birth
     */
    public Human findHumanByDateOfBirth(LocalDate dob) {
        for (Integer key : familyTree.keySet()) {
            if (familyTree.get(key).getDateOfBirth().isEqual(dob)) {
                return familyTree.get(key);
            }
        }
        System.out.println("Human with this date of birth: " + dob + " is not found");
        return null;
    }
}
