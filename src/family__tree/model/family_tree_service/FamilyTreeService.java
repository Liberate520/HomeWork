package family__tree.model.family_tree_service;

import family__tree.model.human.HumanComparatorByBirth;
import family__tree.model.human.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTreeService<E extends ItemFamilyTree<E>> implements Serializable, Iterable<E> {
    private static final long serialVersionUID = 1L;

    private List<E> humans;

    public FamilyTreeService() {
        this.humans = new ArrayList<>();
    }

    public void addHuman(E human) {
        humans.add(human);
    }

    public void addHumans(List<E> humans) {
        this.humans.addAll(humans);
    }

    public void addChild(E parent, E child) {
        parent.addChild(child);
    }

    public void removeHuman(E human) {
        humans.remove(human);
        for (E parent : humans) {
            parent.getChildren().remove(human);
        }
    }

    public List<E> getChildren(E person) {
        return person.getChildren();
    }

    public String getParents(E person) {
        StringBuilder parentsInfo = new StringBuilder();
        E father = person.getFather();
        E mother = person.getMother();
        if (father != null) {
            parentsInfo.append("Отец: ").append(father.getName()).append(", ");
        } else {
            parentsInfo.append("Отец: неизвестен, ");
        }
        if (mother != null) {
            parentsInfo.append("Мать: ").append(mother.getName());
        } else {
            parentsInfo.append("Мать: неизвестна");
        }
        return parentsInfo.toString();
    }

    public List<E> getAllHumans() {
        return humans;
    }

    public void sortByName() {
        humans.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        humans.sort(new HumanComparatorByBirth<>());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Семейное древо:\n");
        for (E human : humans) {
            sb.append(human).append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return humans.iterator();
    }
}