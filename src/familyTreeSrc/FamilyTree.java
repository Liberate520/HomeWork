package familyTreeSrc;

import person.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private long peopleId;
    private List<Human> people;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> people) {
        this.people = people;
    }

    public boolean addHuman(Human human) {
        if (human == null) {
            return false;
        }
        if (!people.contains(human)) {
            people.add(human);
            human.setId(peopleId++);

            addToParents(human);
            addToChildren(human);

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
        for (Human child: human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<Human> getAllChildren(Human person) {
        return person.getChildren();
    }

    public List<Human> getSiblings(int id) {
        Human human = getById(id);
        if (human == null) {
            return null;
        }
        List<Human> res = new ArrayList<>();
        for (Human parent: human.getParents()) {
            for (Human child: parent.getChildren()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<Human> getByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human: people) {
            if (human.getName().equalsIgnoreCase(name)) {
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
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

    public boolean setDivorse(long humanId1, long humanId2) {
        if (checkId(humanId1) && checkId(humanId2)) {
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setDivorse(human1, human2);
        }
        return false;
    }

    public boolean setDivorse(Human human1, Human human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(long humanId) {
        if (checkId(humanId)) {
            Human human = getById(humanId);
            return people.remove(human);
        }
        return false;
    }

    public Human findPersonByName(String name) {
        for (Human person : people) {
            if (person.getName().equalsIgnoreCase(name)) {
                return person;
            }
        }
        return null;
    }

    private boolean checkId(long id) {
        return id < peopleId && id >= 0;
    }

    public Human getById(long id) {
        for (Human human: people) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder res = new StringBuilder();
        res.append("В дереве ");
        res.append(people.size());
        res.append(" объектов: \n");
        for (Human human: people) {
            res.append(human);
            res.append("\n");
        }
        return res.toString();
    }
}
