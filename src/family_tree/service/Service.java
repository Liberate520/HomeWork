package family_tree.service;

import family_tree.family_tree.FamilyTree;
import family_tree.human.Human;

import java.util.Iterator;

public class Service {
    private FamilyTree familyTree;
    private Human human;

    public Service(){
        familyTree = new FamilyTree();
    }
    public void addHuman(Human hum){
        familyTree.addHuman(hum);
    }
    public String getHumansInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей древа:\n");
        Iterator<Human> iterator = familyTree.iterator();
        while (iterator.hasNext()){
            Human human = iterator.next();
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }
    public void sortByName(){
        familyTree.sortByName();
    }
    public void sortByDOB(){
        familyTree.sortByDOB();
    }
}
