package homeWork.model.familyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamTree> implements Serializable, Iterable<T>{
    private List<T> list;
    
    public FamilyTree() {
        this.list = new ArrayList<>();
    }

    public void addHuman(T name) {
        list.add(name);
    }

    public String printTree(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное дерево:\n");
        for (T human : list){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public List<T> getList() {
        return list;
    }
    
    @Override
    public Iterator<T> iterator(){
        return new FamilyTreeIterator<>(list);
    }
}
