package family_tree.tree;

import family_tree.humans.Human;
import family_tree.humans.comparators.HumanComparatorByAge;
import family_tree.humans.comparators.HumanComparatorByBurthDate;
import family_tree.humans.comparators.HumanComparatorByDeathDate;
import family_tree.humans.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humans;

    public FamilyTree() {
        this.humans = new ArrayList<>();
    }

    /**
     * Добавление человека в древо (если человек уже присутствует, то он не добавляется)
     * @param human Человек
     */
    public boolean addHuman(Human human){
        if(human == null){
            return false;
        }
        if(!humans.contains(human)){
            humans.add(human);
            return true;
        }
        return false;
    }

    /**
     * Сортировка по возрасту
     */
    public void sortByAge(){
        humans.sort(new HumanComparatorByAge());
    }

    /**
     * Сортировка по имени
     */
    public void sortByName(){
        humans.sort(new HumanComparatorByName());
    }

    /**
     * Сортировка по возрасту
     */
    public void sortByByrthDate(){
        humans.sort(new HumanComparatorByBurthDate());
    }

    /**
     * Сортировка по дате смерти
     */
    public void sortByDeathDate(){
        humans.sort(new HumanComparatorByDeathDate());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Фамильное древо:\n");

        stringBuilder.append("-----------------\n");
        for (Human human : humans) {
            stringBuilder.append("\t" + human);
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return humans.iterator();
    }
}
