package model.FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyItem> implements Serializable, Iterable<T> {
    private List<T> familyTree;

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    public void addFamilyItem(T familyItem){
        this.familyTree.add(familyItem);
    }

    public String findFamilyItemByName(String name){
        ArrayList<T> foundFamilyItem = new ArrayList<>();
        for (T human : familyTree) {
            if (human.getName().equalsIgnoreCase(name)) {
                foundFamilyItem.add(human);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Results:\n");// \n -перенос строки
        for(T human : foundFamilyItem){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public T findFamilyItemById(int id){
        if (checkId(id)) {
            for (T human : familyTree) {
                if (human.getIdFamilyItem() == id) {
                    return human;
                }
            }
        }
        return null;
    }

    public boolean checkId(int id) {
        if(id>=0 && id<familyTree.size()){
            return true;
        }
        return false;

    }

    public void sortByName(){
        familyTree.sort(new FamilyItemComparatorByName<T>());
    }

    public void sortByAge(){
        familyTree.sort(new FamilyItemComparatorByAge<T>());
    }



    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family Tree:\n");// \n -перенос строки
        for(T human : familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<>(familyTree);
    }



}
