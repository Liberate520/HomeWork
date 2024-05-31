package seminar2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private long humansId;
    private List<Human> humanList;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }

    public boolean add(Human human){
        if(human == null){
            return false;
        }

        if(!humanList.contains(human)){
            humanList.add(human);
            human.setId(humansId++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human){
        for (Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human){
        for(Human child: human.getChildren()){
            child.addParent(human);
        }
    }

    public List<Human> getByNameSurname(String name, String surname){
        List<Human> result = new ArrayList<>();
        for(Human human: humanList){
            if(human.getName().equals(name) && human.getSurname().equals(surname)){
                result.add(human);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder info = new StringBuilder();
        info.append("В дереве ");
        info.append(humanList.size());
        info.append(" объекта(ов): \n");
        for(Human human: humanList){
            info.append(human);
            info.append("\n");
        }

        return info.toString();

    }
}
