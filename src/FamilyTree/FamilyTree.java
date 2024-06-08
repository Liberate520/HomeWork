package FamilyTree;

import Human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> familyTree;

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    public void addHuman(Human human){
        this.familyTree.add(human);
    }

    public String findHumansByName(String name){
        ArrayList<Human> foundHumans = new ArrayList<>();
        for (Human human : familyTree) {
            if (human.getName().equalsIgnoreCase(name)) {
                foundHumans.add(human);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Results:\n");// \n -перенос строки
        for(Human human : foundHumans){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        familyTree.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        familyTree.sort(new HumanComparatorByAge());
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family Tree:\n");// \n -перенос строки
        for(Human human : familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(familyTree);
    }



}
