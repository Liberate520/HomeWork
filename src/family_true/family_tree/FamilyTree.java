/**
 * @author Ostrovskiy Dmitriy
 * @created 19.05.2024
 * class FamilyTree
 * @version v1.0
 */

package family_true.family_tree;

import family_true.api.IndexId;
import family_true.family_tree.defalt_comporator.ComparatorIndexId;
import family_true.human.Human;
import family_true.human.comparator.HumanComparatorByBirthDay;
import family_true.human.comparator.HumanComparatorByLastName;
import family_true.human.iterator.HumanIterator;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human>, Comparable<FamilyTree>, IndexId {

    private static final long serialVersionUID = -8509829358230848460L;

    private long treeId;
    private long humanId;
    private List<Human> humans;

    public FamilyTree(long treeId) {
        this(treeId, new ArrayList<>());
    }

    public FamilyTree(long treeId, List<Human> humans) {
        this.treeId = treeId;
        if (humans == null || humans.size() == 0) {
            this.humanId = 0;
        }
        this.humans = humans == null ? new ArrayList<>() : humans;
    }

    public long getId() {
        return treeId;
    }

    public List<Human> getHumans() {
        return humans;
    }

    public boolean addHuman(Human human) {
        if (human != null && !humans.contains(human)) {
            if (human.getId() == -1) {
                human.setId(humanId++);
            }
            return this.humans.add(human);
        }
        return false;
    }

    public FamilyTree addHumans(List<Human> humans) {
        for (Human human : humans) {
            addHuman(human);
        }
        return this;
    }

    public Human getHumanById(long id) {
        for (Human human : humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public List<Human> findChildrenByParent(Human parent, Human excludeHuman) {
        List<Human> children = new ArrayList<>();
        for (Human human : humans) {
            if (human.isParent(parent) && !human.equals(excludeHuman)) {
                children.add(human);
            }
        }
        return children;
    }

    public List<Human> findChildrenByParentId(long parentId) {
        return findChildrenByParent(getHumanById(parentId), null);
    }

    public List<Human> findSiblingsById(long humanId) {
        Human child = getHumanById(humanId);
        return findChildrenByParent(child.getMother() != null ? child.getMother() : child.getFather(), child);
    }

    public void sortHumansById() {
        Collections.sort(humans, new ComparatorIndexId());
    }

    public void sortHumansByBirthDay() {
        Collections.sort(humans, new HumanComparatorByBirthDay());
    }

    public void sortHumansByLastName() {
        Collections.sort(humans, new HumanComparatorByLastName());
    }

    @Override
    public int getIndexId() {
        return Math.toIntExact(getId());
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "treeId=" + treeId +
                ", size=" + humans.size() +
                ", humans=" + humans +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyTree that = (FamilyTree) o;
        return treeId == that.treeId && humanId == that.humanId && Objects.equals(humans, that.humans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(treeId, humanId, humans);
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humans);
    }

    @Override
    public int compareTo(FamilyTree tree) {
        return Integer.compare(this.getIndexId(), tree.getIndexId());
    }
}
