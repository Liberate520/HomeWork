package family_tree.tree;

import family_tree.interfaces.Comparable;
import family_tree.person.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class FamilyTree implements Serializable {
    private long countPeople = 1;
    private Map<Integer, ArrayList<Human>> familyTree; //Integer - generation

    public FamilyTree() {
        familyTree = new HashMap<>();
    }

    public FamilyTree(HashMap<Integer, ArrayList<Human>> tree) {
        familyTree = tree;
    }

    public boolean addPersonToFamily(Human person, Integer generation) {
        if (person == null) {
            return false;
        }
        if (!familyTree.containsKey(generation)) {
            familyTree.put(generation, new ArrayList<>());
        } else {
            for (Human item : familyTree.get(generation)) {
                if (item.equals(person)) {
                    System.out.println("This man already recorded in the family tree");
                    return false;
                }
            }
        }
        familyTree.get(generation).add(person);
        person.setId(countPeople++);
        return true;
    }

    public Human findHumanByName(String name) {
        for (ArrayList<Human> item : familyTree.values()) {
            for (Human person : item) {
                if (person.getName().equalsIgnoreCase(name)) {
                    return person;
                }
            }
        }
        System.out.println("Human with name: " + name + " is not found");
        return null;
    }

    /**
     * @param dob (LocalDate)
     * @return first human with this date of birth
     */
    public Human findHumanByDateOfBirth(LocalDate dob) {
        for (ArrayList<Human> item : familyTree.values()) {
            for (Human person : item) {
                if (person.getDateOfBirth().isEqual(dob)) {
                    return person;
                }
            }
        }
        System.out.println("Human with this date of birth: " + dob + " is not found");
        return null;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        for (Integer key : familyTree.keySet()) {
            sb.append("Generation ").append(key).append(": \n");
            for (Human person : familyTree.get(key)) {
                sb.append(person.getInfo()).append("\n").append("-".repeat(20)).append("\n");
            }
            sb.append("--".repeat(20)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }


    private ArrayList<Human> convertToList() {
        ArrayList<Human> res = new ArrayList<>();
        for (ArrayList<Human> item : familyTree.values()) {
            res.addAll(item);
        }
        return res;
    }

    public ArrayList<Human> sortByAge() {
        ArrayList<Human> sortedFamilyList = convertToList();
        sortedFamilyList.sort(Comparator.comparingInt(Human::getAge));
        return sortedFamilyList;
    }

    public ArrayList<Human> sortByName() {
        ArrayList<Human> sortedFamilyList = convertToList();
        sortedFamilyList.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        return sortedFamilyList;
    }

    public ArrayList<String> getListOfNames(ArrayList<Human> peopleList) {
        ArrayList<String> listOfNames = new ArrayList<>();
        for (Human item : peopleList) {
            listOfNames.add(item.getName());
        }
        return listOfNames;
    }

}
