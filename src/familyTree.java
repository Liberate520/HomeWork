import java.util.ArrayList;
import java.util.List;

public class familyTree {
    private int countPeople;
    private List<Human> humanList;
    public familyTree(List<Human> humanList) {
        this.humanList = humanList;
    }
    public familyTree(){
        this(new ArrayList<>());
    }


    public boolean add(Human human){
        if(human == null){
            return false;
        }
        if(!humanList.contains(human)){
            humanList.add(human);
            human.setId(countPeople++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human){
        for(Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human){
        for(Human children: human.getChildren()){
            children.addParent(human);
        }
    }

    public List<Human> searchByName(String name){
        List<Human> res = new ArrayList<>();
        for(Human human: humanList){
            if(human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    public boolean remove(int humanId){
        if(checkId(humanId)){
            Human human = getById(humanId);
            return humanList.remove(human);
        }
        return false;
    }

    private boolean checkId(int id){
        return id < countPeople && id >= 0;
    }

    public Human getById(int id){
        if(checkId(id)){
            for (Human human: humanList){
                if(human.getId() == id){
                    return human;
                }
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("В дереве ");
        stringBuilder.append(humanList.size());
        stringBuilder.append(" объектов: \n");
        for(Human human: humanList){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
