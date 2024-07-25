package FamiliTree;

import Human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FamilyTree implements Serializable {

    private long humanId;
    private List<Human> humans;

    public FamilyTree() {
        this.humanId = 1;
        this.humans = humans == null ? new ArrayList<>() : humans;
    }


    public Human getByName(String nameHuman) { //  поиск по имени
        for (Human human : humans) {
            if (human.getName().equals(nameHuman)) {
                return human;
            }
        }
        return null;
    }

    public Human getById(long id) { //  поиск по id
        for (Human human : humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
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
        return findChildrenByParent(getById((int) parentId), null);
    }

    public List<Human> findSiblingsById(long humanId) {
        Human child = getById((int) humanId);
        return findChildrenByParent(child.getMother() != null ? child.getMother() : child.getFather(), child);
    }




    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Генеалогическое древо (размер = " + humans.size() + "):");

        for (Human human : humans) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString().replaceAll("^\\[|\\,|\\]$", "");
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        FamilyTree that = (FamilyTree) obj;
        return humanId == that.humanId && Objects.equals(humans, that.humans);
    }

    @Override
    public int hashCode() {
        return Objects.hash(humanId, humans);
    }

}
