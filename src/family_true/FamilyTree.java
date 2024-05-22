/**
 * @author Ostrovskiy Dmitriy
 * @created 19.05.2024
 * class FamilyTree
 * @version v1.0
 */

package family_true;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FamilyTree {

    private long treeId;
    private long humanId;
    private List<Human> humans;

    public FamilyTree(long treeId) {
        this(treeId, new ArrayList<>());
    }

    public FamilyTree(long treeId, List<Human> humans) {
        this.treeId = treeId;
        this.humanId = 1;
        this.humans = humans == null ? new ArrayList<>() : humans;
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
}
