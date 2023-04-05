package tree.familyTree;

import tree.human.Human;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> peopleList;

    public FamilyTree() {
        this.peopleList = new ArrayList<>();
    }

    public void addHuman(Human human) {
        this.peopleList.add(human);
    }

    public List<Human> getPeopleList() {
        return peopleList;
    }

    public Set<Human> getChildren(Human human) {
        return human.getChildren();
    }

    public Set<Human> getParents(Human human) {
        return human.getParents();
    }

    /**
     * функция getDescendants ищет потомков для
     * указанного персонажа
     * 
     * @param Human - получает объект персонажа
     * @return - возвращает список потомков
     */
    public Set<Human> getDescendants(Human Human) {
        Set<Human> descendants = new HashSet<>();
        for (Human child : Human.getChildren()) {
            descendants.add(child);
            descendants.addAll(getDescendants(child));
        }
        return descendants;
    }

    /**
     * функция getAncestors ищет предков для
     * указанного персонажа
     * 
     * @param Human - получает объект персонажа
     * @return - возвращает список предков
     */
    public Set<Human> getAncestors(Human Human) {
        Set<Human> ancestors = new HashSet<>();
        for (Human parent : Human.getParents()) {
            ancestors.add(parent);
            ancestors.addAll(getAncestors(parent));
        }
        return ancestors;
    }

    /**
     * функция getRelatives ищет родственные связи для
     * указанного персонажа
     * 
     * @param Human - получает объект персонажа
     * @return - возвращает список связей
     */
    public Set<Human> getRelatives(Human Human) {
        Set<Human> relatives = new HashSet<>();
        relatives.addAll(getAncestors(Human));
        relatives.addAll(getDescendants(Human));
        return relatives;
    }

    public Set<Human> searchByNames(String firstName, String lastName) {
        Set<Human> result = new HashSet<>();
        for (Human human : peopleList) {
            if (human.getFirstName() == firstName && human.getLastName() == lastName) {
                result.add(human);
            }
        }
        return result;
    }

    @Override
    public Iterator<Human> iterator() {
        return peopleList.iterator();
    }
}
