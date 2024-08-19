package homeWork.Model.Tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import homeWork.Model.Human.Human;
import homeWork.Model.Human.Comporators.ComparingByBirthday;
import homeWork.Model.Human.Comporators.ComparingByName;

public class FamilyTree<T extends TreeItem> implements Serializable, Iterable<T> {
    private List<T> familyTree = new ArrayList<>();



    public void addHuman(T human ){
        familyTree.add(human);
    }


    public String getFamilyTree(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи:\n");
        for (T object : familyTree){
            stringBuilder.append(object);
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