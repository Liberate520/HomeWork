package family_tree.tree;

import family_tree.tree.sorting.Comparable;
import family_tree.tree.sorting.SortByAge;
import family_tree.tree.sorting.SortByDateOfBirth;
import family_tree.tree.sorting.SortByName;
import family_tree.person.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class FamilyTree<T extends Human> implements Serializable, Iterable<T>, Comparable<T> {
    private long countPeople = 1;
    private Map<Integer, ArrayList<T>> familyTree; //Integer - generation

    public FamilyTree() {
        familyTree = new HashMap<>();
    }

    public FamilyTree(HashMap<Integer, ArrayList<T>> tree) {
        familyTree = tree;
    }

    public boolean addPersonToFamily(T person, Integer generation) {
        if (person == null) {
            return false;
        }
        if (!familyTree.containsKey(generation)) { //TODO может быть ошибка в generation. Не безопасно! Пересмотреть условия
            familyTree.put(generation, new ArrayList<>());
        } else {
            if (familyTree.get(generation).contains(person)) {
                System.out.println("This man already recorded in the family tree");
                return false;
            }
        }
        familyTree.get(generation).add(person);
        person.setId(countPeople++);
        return true;
    }

    public T findHumanByName(String name) {
        iterator();
        for (T person : this) { //?
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        System.out.println("Human with name: " + name + " is not found");
        return null;
    }

    /**
     * @param dob (LocalDate)
     * @return first human with this date of birth
     */
    public T findHumanByDateOfBirth(LocalDate dob) {
        for (ArrayList<T> item : familyTree.values()) {
            for (T person : item) {
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
            for (T person : familyTree.get(key)) {
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


    public ArrayList<T> convertToList(Map<Integer, ArrayList<T>> familyTree) {
        ArrayList<T> res = new ArrayList<>();
        for (ArrayList<T> item : familyTree.values()) {
            res.addAll(item);
        }
        return res;
    }
    @Override
    public ArrayList<T> sorting() {
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        ArrayList<T> res = convertToList(familyTree);
        while (flag) {
            System.out.println("Enter the number of type of sorting (by Name is 1, by Age is 2 or by Date of birth is 3): ");
            int request = in.nextInt();
            switch (request) {
                case (1):
                    res.sort(new SortByName<>());
                    flag = false;
                    break;
                case (2):
                    res.sort(new SortByAge<>());
                    flag = false;
                    break;
                case (3):
                    res.sort(new SortByDateOfBirth<>());
                    flag = false;
                    break;
                default:
                    System.out.println("An incorrect request was entered. Try to enter again");
            }
        }
        in.close();
        return res;
    }


    public ArrayList<String> getListOfNames(ArrayList<T> peopleList) {
        ArrayList<String> listOfNames = new ArrayList<>();
        for (Human item : peopleList) {
            listOfNames.add(item.getName());
        }
        return listOfNames;
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<T>(convertToList(familyTree));
    }

    public Map<Integer, ArrayList<T>> getFamilyTree() {
        return familyTree;
    }

}
