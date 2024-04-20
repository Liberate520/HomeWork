package Family_Tree.FamilyTree;

import Family_Tree.Human.SortByAge;
import Family_Tree.Human.SortByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeVersatility<E>> implements Iterable<E>, Serializable {
    private long countPeople; //Лучше перенести в main
    private List<E> HumanList;
    private FamilyTree familytree;

    public FamilyTree() {
        HumanList = new ArrayList<>();
    }

    public FamilyTree(List<E> HumanList) {
        this.HumanList = HumanList;
    }

    public boolean add(E human) {
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
    public Iterator<E> iterator() {
        return new HumanIterator(HumanList);
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве");
        sb.append(HumanList.size());
        sb.append(" объектов ");
        sb.append("\n");
        for (E human : HumanList) {
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


    private void addToParents(E human) {
        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParents(human);
        }
    }

    public E getID(long id) {
        for (E human : HumanList) {
            if (human.getID() == id) {
                return human;
            }
        }
        return null;
    }

    public void sortByName(){
        HumanList.sort(new SortByName<>());
    }
    public void sortByAge(){
        HumanList.sort(new SortByAge<>());
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




