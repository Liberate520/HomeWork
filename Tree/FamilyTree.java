package homeWork.Tree;

import homeWork.Human.Comporators.ComparingByName;
import homeWork.Human.Comporators.ComparingByBirthday;
import homeWork.Human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends TreeItem> implements Serializable, Iterable<T> {
    private List<T> familyTree = new ArrayList<>();



    public void addHuman(T human ){
        familyTree.add(human);
    }


    public String getFamilyTree(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи:\n");
        for (T human : familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void removeHuman(T object){
        familyTree.remove(object);
    }

    public void setFamilyTree(List<T> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator(familyTree);
    }

    public void sortByName(){
        familyTree.sort(new ComparingByName());
    }

    public void sortByAge(){
        familyTree.sort(new ComparingByBirthday());
    }
}