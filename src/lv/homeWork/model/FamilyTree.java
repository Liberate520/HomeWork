package lv.homeWork.model;

import lv.homeWork.model.comparators_iterators.CompareByBirth;
import lv.homeWork.model.comparators_iterators.CompareByGen;
import lv.homeWork.model.comparators_iterators.IteratorForTree;
import lv.homeWork.model.objects.TreeNode;
import lv.homeWork.model.objects.Human;
import lv.homeWork.model.GenerationCalculator;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {

    private final List<E> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(ArrayList<E> humanList) {
        this.humanList = humanList;
    }

    public void addHuman(E human) {
        if (!humanList.contains(human)) {
            humanList.add(human);
            GenerationCalculator.setGeneration((Human) human);
        }
    }

    public void addHuman(Integer passportID, String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, Human mother, Human father) {
        HumanFactory factory = new HumanFactory();
        Human newHuman = factory.createHuman(passportID, name, gender, dateOfBirth, dateOfDeath, mother, father);
        addHuman((E) newHuman);
    }

    public void addHuman(Integer passportID, String name, Gender gender, LocalDate dateOfBirth, Human mother, Human father) {
        HumanFactory factory = new HumanFactory();
        Human newHuman = factory.createHuman(passportID, name, gender, dateOfBirth, mother, father);
        addHuman((E) newHuman);
    }

    public void addHuman(Integer passportID, String name, Gender gender, LocalDate dateOfBirth) {
        HumanFactory factory = new HumanFactory();
        Human newHuman = factory.createHuman(passportID, name, gender, dateOfBirth);
        addHuman((E) newHuman);
    }

    public List<E> findByGeneration(int generation) {
        List<E> result = new ArrayList<>();
        for (E human : humanList) {
            if (((Human) human).getGeneration() == generation) {
                result.add(human);
            }
        }
        return result;
    }

    public boolean removeHuman(E human) {
        return humanList.remove(human);
    }

    public E findHumanByName(String name) {
        for (E human : humanList) {
            if (((Human) human).getName().equalsIgnoreCase(name)) {
                return human;
            }
        }
        return null;
    }

    public void sortByBrith() {
        humanList.sort(new CompareByBirth<>());
    }

    public void sortByGen() {
        humanList.sort(new CompareByGen<>());
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder("Family tree contains: \n");
        for (E human : humanList) {
            sb.append(((Human) human).getInfo()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new IteratorForTree<>(humanList);
    }
}
