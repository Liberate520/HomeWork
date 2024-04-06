import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree(){
        humanList = new ArrayList<>();
    }

    public boolean addHumantoTree (Human human) {
        if (!humanList.contains(human)){
            humanList.add(human);
            addhumantoParents(human);
            addhumantoChild(human);
        }
        return true;
    }

    private boolean addhumantoChild(Human human) {
        for(Human child: human.getChildrenList()){
            child.addParents(human);
        }
        return true;
    }

    private void addhumantoParents(Human human) {
        for(Human parent: human.getParents()){
            parent.addChildren(human);
        }
    }

    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В семейном дереве сейчас: ");
        sb.append(humanList.size()).append(" Чел."+"\n");
        for (Human human: humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}


