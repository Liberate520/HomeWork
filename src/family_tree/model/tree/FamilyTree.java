package family_tree.model.tree;

import family_tree.model.person.TreeNode;
import family_tree.model.tree.sorting.SortByAge;
import family_tree.model.tree.sorting.SortByDateOfBirth;
import family_tree.model.tree.sorting.SortByGeneration;
import family_tree.model.tree.sorting.SortByName;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private ArrayList<E> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    public FamilyTree(ArrayList<E> tree) {
        familyTree = tree;
    }

    public boolean addPersonToFamily(E person) {
        if (person == null) {
            return false;
        }
        if (!familyTree.contains(person)) {
            familyTree.add(person);
            return true;
        } else {
            System.out.println("This subject already recorded in the family tree");
            return false;
        }
    }


    public E findUnitByName(String name) {
        for (E person : this) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
            if (person.getName().contains(name)) {
                return person;
            }
        }
        return null;
    }

    /**
     * @param dob (LocalDate)
     * @return first human with this date of birth
     */
    public E findHumanByDateOfBirth(LocalDate dob) {
        for (E person : this) {
            if (person.getDateOfBirth().isEqual(dob)) {
                return person;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        //int gen = 0;
        for (E subject : familyTree) {
//            if (gen != subject.getGeneration()) {
//                sb.append("==".repeat(20)).append("\n");
//                gen = subject.getGeneration();
//                sb.append("Generation ").append(gen).append(": \n");
//            }
            sb.append(subject).append("\n").append("-".repeat(20)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }


    public ArrayList<E> sortByAge() {
        ArrayList<E> res = familyTree;
        res.sort(new SortByAge<E>());
        return res;
    }

    public ArrayList<E> sortByDateOfBirth() {
        ArrayList<E> res = familyTree;
        res.sort(new SortByDateOfBirth<E>());
        return res;
    }

    public ArrayList<E> sortByName() {
        ArrayList<E> res = familyTree;
        res.sort(new SortByName<>());
        return res;
    }

    public ArrayList<E> sortByGeneration() {
        ArrayList<E> res = familyTree;
        res.sort(new SortByGeneration<>());
        return res;
    }

    public ArrayList<E> getFamilyTree() {
        return familyTree;
    }

    public ArrayList<String> getListOfNames() {
        ArrayList<String> listOfNames = new ArrayList<>();
        for (E item : this) {
            listOfNames.add(item.getName() + "\n");
        }
        return listOfNames;
    }
    public ArrayList<String> getListOfNamesFromInputList(ArrayList<E> inputList) {
        ArrayList<String> listOfNames = new ArrayList<>();
        for (E item : inputList) {
            listOfNames.add(item.getName() + "\n");
        }
        return listOfNames;
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(familyTree);
    }
}
