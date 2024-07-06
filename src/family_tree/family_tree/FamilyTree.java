package family_tree.family_tree;

import family_tree.creators.Creators;
import family_tree.creators.IDGenerator;
import family_tree.creators.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree<T extends Creators> implements Serializable  {
    private final int id;
    private int creatorId;
    private String name;
    private List<T> creatorList;

    public FamilyTree(String name, List<T> creatorList) {
        this.id = IDGenerator.generateID();
        this.name = name;
        this.creatorList = creatorList;
    }

    public FamilyTree() {
        this(null, new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public List<T> getCreatorList() {
        return creatorList;
    }

    public void setCreatorList(List<T> creatorList) {
        this.creatorList = creatorList;
    }

    public boolean add(T creator) {
        if (creator == null) {
            return false;
        }

        if (!creatorList.contains(creator)) {
            creatorList.add(creator);

            if (creator.getId() > this.creatorId) {
                this.creatorId = creator.getId();
            }

            if (creator instanceof Human) {
                addToParents((Human) creator);
                addToChildren((Human) creator);
            }
            return true;
        }
        return false;
    }

    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<Human> getSiblings(int sibId) {
        Human human = (Human) getById(sibId);
        if (human == null) {
            return null;
        }
        List<Human> res = new ArrayList<>();
        for (Human parent : human.getParents()) {
            for (Human child : human.getChildren()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<T> getByName(String name) {
        List<T> res = new ArrayList<>();
        for (T creator : creatorList) {
            if (creator.getName().equals(name)) {
                res.add(creator);
            }
        }
        return res;
    }

    public boolean setWedding(int humanId1, int humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = (Human) getById(humanId1);
            Human human2 = (Human) getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }

    public boolean setWedding(Human human1, Human human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }

    public boolean setDivorce(int humanId1, int humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = (Human) getById(humanId1);
            Human human2 = (Human) getById(humanId2);
            return setDivorce(human1, human2);
        }
        return false;
    }

    public boolean setDivorce(Human human1, Human human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(int creatorId) {
        if (checkId(creatorId)) {
            T creator = getById(creatorId);
            return creatorList.remove(creator);
        }
        return false;
    }

    private int calculateMaxId(List<T> creatorList) {
        int maxId = 0;
        for (T creator : creatorList) {
            if (creator.getId() > maxId) {
                maxId = creator.getId();
            }
        }
        return maxId;
    }

    private boolean checkId(int idForCheck) {
        return idForCheck < creatorId && idForCheck >= 0;
    }

    public T getById(int idForGet) {
        for (T creator : creatorList) {
            if (creator.getId() == idForGet) {
                return creator;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("ID дерева: ");
        sb.append(getId());
        sb.append(", имя дерева: ");
        sb.append(getName());
        sb.append("\n");
        sb.append("В дереве ");
        sb.append(creatorList.size());
        sb.append(" объектов: ");
        sb.append("\n");
        for (T creator : creatorList) {
            sb.append(creator);
            sb.append("\n");
        }
        return sb.toString();
    }
}
