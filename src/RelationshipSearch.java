import java.util.ArrayList;
import java.util.List;

/**
 * Класс для поиска родственных связей в генеалогическом древе.
 * Предоставляет методы для поиска родителей, супруга, братьев/сестер выбранного человека.
 */
public class RelationshipSearch {
    /**
     * Возвращает список родителей указанного человека.
     *
     * @param person человек, для которого нужно найти родителей
     * @return список родителей
     */
    public List<Human> getParents(Human person) {
        List<Human> parents = new ArrayList<>();
        for (Human member : person.getParents()) {
            parents.add(member);
        }
        return parents;
    }

    /**
     * Возвращает супруга указанного человека.
     *
     * @param person человек, для которого нужно найти супруга
     * @return супруг человека
     */
    public Human getSpouse(Human person) {
        return person.getSpouse();
    }

    /**
     * Возвращает список братьев и сестер указанного человека.
     *
     * @param person человек, для которого нужно найти братьев и сестер
     * @return список братьев и сестер
     */
    public List<Human> getSiblings(Human person) {
        List<Human> siblings = new ArrayList<>();
        if (person.getParents().size() == 2) {
            Human parent1 = person.getParents().get(0);
            Human parent2 = person.getParents().get(1);
            for (Human child : parent1.getChildren()) {
                if (!child.equals(person)) {
                    siblings.add(child);
                }
            }
            for (Human child : parent2.getChildren()) {
                if (!child.equals(person) && !siblings.contains(child)) {
                    siblings.add(child);
                }
            }
        }
        return siblings;
    }
}