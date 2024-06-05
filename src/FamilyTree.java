import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private long humansId;
    private List<Human> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);

            addToParants(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParants(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChildren(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParents(human);
        }
    }

    public List<Human> getSiblings(int id) {
        Human human = getById(id);
        if (human == null) {
            return null;
        }
        List<Human> res = new ArrayList<>();
        for (Human parent : human.getParents()) {
            for (Human child : parent.getChildren()) {
                if (!child.equals(human)) {
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<Human> getByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    public boolean setWedding(long humansId1, long humansId2) {
        if (checkId(humansId1) && checkId(humansId2)) {
            Human human1 = getById(humansId1);
            Human human2 = getById(humansId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null) {
                human1.setSpouse(human2);
                human2.setSpouse(human1);
            } else return false;
        }
        return false;
    }

    public boolean setDivorce(long humansId1, long humansId2) {
        if (checkId(humansId1) && checkId(humansId2)) {
            Human human1 = getById(humansId1);
            Human human2 = getById(humansId2);
            if (human1.getSpouse() != null && human2.getSpouse() != null) {
                human1.setSpouse(null);
                human2.setSpouse(null);
            } else return false;
        }
        return false;
    }

    public boolean remove(long humansId) {
        if (checkId(humansId)) {
            Human human = getById(humansId);
            return humanList.remove(human);
        }
        return false;
    }

    private boolean checkId(long id) {
        return id < humansId && id >= 0;
    }

    public Human getById(long id) {
        for (Human human : humanList) {
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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("В дереве ");
        stringBuilder.append(humanList.size());
        stringBuilder.append(" объектов: \n");
        for (Human human : humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
