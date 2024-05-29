/**
 * @author Ostrovskiy Dmitriy
 * @created 19.05.2024
 * class FamilyTree
 * @version v1.0
 */

package family_true.family_tree;

import family_true.api.Entity;
import family_true.api.IndexId;
import family_true.family_tree.defalt_comporator.ComparatorIndexId;
import family_true.human.comparator.ComparatorByBirthDay;
import family_true.human.comparator.ComparatorByLastName;
import family_true.human.iterator.EntityIterator;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends Entity> implements Serializable, Iterable<T>, Comparable<FamilyTree>, IndexId {

    private static final long serialVersionUID = -8509829358230848460L;

    private long treeId;
    private long entityId;
    private List<T> entities;

    public FamilyTree(long treeId) {
        this(treeId, new ArrayList<>());
    }

    public FamilyTree(long treeId, List<T> entities) {
        this.treeId = treeId;
        if (this.entities == null || this.entities.size() == 0) {
            this.entityId = 0;
        }
        this.entities = this.entities == null ? new ArrayList<>() : this.entities;
    }

    public long getId() {
        return treeId;
    }

    public List<T> getEntities() {
        return entities;
    }

    public boolean addEntity(T entity) {
        if (entity != null && !entities.contains(entity)) {
            if (entity.getId() == -1) {
                entity.setId(entityId++);
            }
            return this.entities.add(entity);
        }
        return false;
    }

    public FamilyTree addEntities(List<T> entities) {
        for (T entity : entities) {
            addEntity(entity);
        }
        return this;
    }

    public T getHumanById(long id) {
        for (T entity : entities) {
            if (entity.getId() == id) {
                return entity;
            }
        }
        return null;
    }

    public List<T> findChildrenByParent(T parent, T excludeHuman) {
        List<T> children = new ArrayList<>();
        for (T entity : entities) {
            if (entity.isParent(parent) && !entity.equals(excludeHuman)) {
                children.add(entity);
            }
        }
        return children;
    }

    public List<T> findChildrenByParentId(long parentId) {
        return findChildrenByParent(getHumanById(parentId), null);
    }

    public List<T> findSiblingsById(long humanId) {
        T child = getHumanById(humanId);
        T parent = (T) (child.getMother() != null ? child.getMother() : child.getFather());
        return findChildrenByParent(parent, child);
    }

    public void sortHumansById() {
        Collections.sort(entities, new ComparatorIndexId());
    }

    public void sortHumansByBirthDay() {
        Collections.sort(entities, new ComparatorByBirthDay<T>());
    }

    public void sortHumansByLastName() {
        Collections.sort(entities, new ComparatorByLastName<T>());
    }

    @Override
    public Iterator<T> iterator() {
        return new EntityIterator(entities);
    }

    @Override
    public int compareTo(FamilyTree tree) {
        return Integer.compare(this.getIndexId(), tree.getIndexId());
    }

    @Override
    public int getIndexId() {
        return Math.toIntExact(getId());
    }

    @Override
    public String toString() {
        return "FamilyTree{" +
                "treeId=" + treeId +
                ", size=" + entities.size() +
                ", humans=" + entities +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyTree that = (FamilyTree) o;
        return treeId == that.treeId && entityId == that.entityId && Objects.equals(entities, that.entities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(treeId, entityId, entities);
    }
}
