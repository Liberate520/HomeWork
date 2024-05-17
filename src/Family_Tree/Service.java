package Family_Tree;/*
package Family_Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Service {
    private FamilyTree familytree;
    private List<Human> HumanList;
    private long countPeople;

    public Service(){
        familytree = new FamilyTree();
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

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        */
/*sb.append("В дереве");
        sb.append(HumanList.size());
        sb.append(" объектов ");*//*

        sb.append("Список объектов дерева: ");
        for (Human human : familytree) {
            sb.append(human);
            sb.append("\n");
        }

        Iterator<Human> iterator = familytree.iterator();
        while (iterator.hasNext()) {
            Human human = iterator.next();
            sb.append(human);
            sb.append("\n");
        }
            return sb.toString();
        }
    }
*/
