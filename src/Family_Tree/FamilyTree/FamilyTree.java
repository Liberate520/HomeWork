package Family_Tree.FamilyTree;

import Family_Tree.Human.Human;
import Family_Tree.Human.SortByAge;
import Family_Tree.Human.SortByName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Iterable<Human> {
    private long countPeople; //Лучше перенести в main
    private List<Human> HumanList;
    private FamilyTree familytree;

    public FamilyTree() {
        HumanList = new ArrayList<>();
    }

    public FamilyTree(List<Human> HumanList) {
        this.HumanList = HumanList;
    }

    public boolean add(Human human) {
        if (human == null) {
            return false;
        }
        if (!HumanList.contains(human)) {
            HumanList.add(human);
            human.setID(countPeople++);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(HumanList);
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве");
        sb.append(HumanList.size());
        sb.append(" объектов ");
        sb.append("\n");
        for (Human human : HumanList) {
            sb.append(human);
            sb.append("\n");
        }

        /*Iterator<Human> iterator = HumanList.iterator();
        while (iterator.hasNext()) {
            Human human = iterator.next();
            sb.append(human);
            sb.append("\n");
        }*/
        return sb.toString();
    }


    private void addToParents(Human human) {
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child : human.getChildren()) {
            child.addParents(human);
        }
    }

    public Human getID(long id) {
        for (Human human : HumanList) {
            if (human.getID() == id) {
                return human;
            }
        }
        return null;
    }

    public void sortByName(){
        Collections.sort(HumanList, new SortByName());
    }
    public void sortByAge(){
        Collections.sort(HumanList, new SortByAge());
    }
    /*public List<Human> getSib(int id){   Разобраться в методе(нахождение братьев и сестер)
        Human human = getID(id);
        if(human == null){
            return null;
        }
        List<Human> res = new ArrayList<>();
        for(Human parent: human.getParents()){
            for(Human child: human.getChildren()){
                if(!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }*/

    @Override
    public String toString() {
        return getInfo();
    }

    /*public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве");
        sb.append(HumanList.size());
        sb.append(" объектов ");
        for (Human human : HumanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();

    }*/

}




