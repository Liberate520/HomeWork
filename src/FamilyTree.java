import java.util.ArrayList;
import java.util.List;

public class FamilyTree {private long humansId;
    private List<Human> humans;

    public FamilyTree(List<Human> humanList) {
        this.humans = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean addHuman(Human human){

        if (human==null){
            return false;
        }
        if (!humans.contains(human)){
            humans.add(human);
            human.setId(humansId++);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    private void addToParents(Human human){
        for (Human parent :human.getParents()){
            parent.addChild(human);
        }

    }
    private  void  addToChildren(Human human){
        for (Human child :human.getChildren()){
            child.addParent(human);
        }
    }
    public List<Human> getSiblings(int id){
        Human human = getById(id);

        if (human==null){
            return null;
        }
        List<Human> siblings = new ArrayList<>();
        for (Human parent: human.getParents())
        {
            for (Human child: human.getChildren()){
                if (!child.equals(human)){
                    siblings.add(child);
                }
            }
        }

        return siblings;
    }
    public Human getById(long id) {
        for (Human human : humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
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
    public boolean setFamily(Human human1, Human human2) {
        if (!human2.getParents().contains(human1)) {
            if (human1.getSex().equals(Gender.Female)){
                human2.setMother(human1);
                human1.addChild(human2);
            }
            else if (human1.getSex().equals(Gender.Male)){
                human2.setFather(human1);
                human1.addChild(human2);
            }

            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("В дереве ");
        sb.append(humans.size());
        sb.append(" объектов: ");
        sb.append("\n");
        for (Human human : humans) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}
