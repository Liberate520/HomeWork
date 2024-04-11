package family_tree.tree;

import family_tree.person.BasicUnit;
import family_tree.tree.HumanIterator;
import family_tree.tree.sorting.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class FamilyTree<T extends BasicUnit> implements Serializable, Iterable<T> {
    private long countPeople = 1;
    private ArrayList<T> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public FamilyTree(ArrayList<T> tree) {
        familyTree = tree;
    }

    public boolean addPersonToFamily(T person, int generation) {
        if (person == null) {
            return false;
        }
        if (!familyTree.contains(person)) { //TODO может быть ошибка в generation. Не безопасно! Пересмотреть условия
            familyTree.add(person);
            person.setGeneration(generation);
            return true;
        } else {
            System.out.println("This man already recorded in the family tree");
            return false;
        }
    }


    public T findUnitByName(String name) {
        for (T person : this) {
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
        for (T person : this) {
            if (person.getDateOfBirth().isEqual(dob)) {
                return person;
            }
        }
        System.out.println("Human with this date of birth: " + dob + " is not found");
        return null;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        int gen = 0;
        for (T unit : sortByGeneration()) {
            if (gen != unit.getGeneration()) {
                sb.append("==".repeat(20)).append("\n");
                gen = unit.getGeneration();
                sb.append("Generation ").append(gen).append(": \n");
            }
            sb.append(unit.getInfo()).append("\n").append("-".repeat(20)).append("\n");
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

    public ArrayList<T> sorting(int request) {
        boolean flag = true;
        ArrayList<T> res = familyTree;
        while (flag) {
            System.out.println("Enter the number of type of sorting (by Name is 1, by Age is 2 or by Date of birth is 3): ");
            switch (request) {
                case (1):
                    res = sortByName();
                    flag = false;
                    break;
                case (2):
                    res = sortByAge();
                    flag = false;
                    break;
                case (3):
                    res = sortByDateOfBirth();
                    flag = false;
                    break;
                default:
                    System.out.println("An incorrect request was entered. Try to enter again");
            }
        }
        return res;
    }

    public ArrayList<T> sortByAge() {
        ArrayList<T> res = familyTree;
        res.sort(new SortByAge<>());
        return res;
    }

    public ArrayList<T> sortByDateOfBirth() {
        ArrayList<T> res = familyTree;
        res.sort(new SortByDateOfBirth<>());
        return res;
    }

    public ArrayList<T> sortByName() {
        ArrayList<T> res = familyTree;
        res.sort(new SortByName<>());
        return res;
    }

    public ArrayList<T> sortByGeneration() {
        ArrayList<T> res = familyTree;
        res.sort(new SortByGeneration<>());
        return res;
    }

    public ArrayList<T> getFamilyTree() {
        return familyTree;
    }

    public ArrayList<String> getListOfNames(ArrayList<T> peopleList) {
        ArrayList<String> listOfNames = new ArrayList<>();
        for (T item : peopleList) {
            listOfNames.add(item.getName());
        }
        return listOfNames;
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(familyTree);
    }
}
