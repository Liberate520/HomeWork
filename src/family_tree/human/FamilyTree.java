package family_tree.human;

import family_tree.FamilyTreeItem;

import java.io.Serializable;
import java.util.*;

//public class FamilyTree implements Serializable,Iterable<Human>{
public class FamilyTree<T extends FamilyTreeItem<T>> implements Serializable,Iterable<T>{
    public List<T> humanList;

    public FamilyTree() {
        humanList=new ArrayList<T>();
    }

    public FamilyTree(List<T> humanList) {
        this.humanList = humanList;
    }

    public void addHuman(T human){
        if (human!=null){
            if (!humanList.contains(human)){
                humanList.add(human);

                addChildToParents(human);
                addParentsToChild(human);
            }
        }
    }
    private void addChildToParents(T human){  //добавить родителям ребёнка
        if (human.getMother()!=null)
          human.getMother().addChild(human);
        if (human.getFather()!=null)
           human.getFather().addChild(human);
    }
    private void addParentsToChild(T human){  //К детям родителя
        if(human.getGender()==Gender.FEMALE)
           human.getChildren().forEach((ch)->ch.addMother(human)) ;


        if(human.getGender()==Gender.MALE)
            human.getChildren().forEach((ch)->ch.addFather(human)) ;

    }
    public T getById(int id){
        for (T human : humanList) {
            if (human.getId()==id)return human;
        }
        return null;
    }
    public  List<T> getByName(String name){
        List<T> humans=new ArrayList<>();
        for (T human : humanList) {
            if (human.getName().equals(name)) humans.add(human);
        }
        return humans;
    }
    public  List<T> getSiblings(int id){   //найти братьев и сестёр
        T humanId=getById(id);
        if (humanId==null)return null;

        List<T> humans=new ArrayList<>();
        if (humanId.getFather()!=null) {
            for (T human : humanId.getFather().getChildren()) {
                if (!human.equals(humanId))
                 humans.add(human);
            }
            return humans;
        }
        else return null;
    }

    public void sortByName(){
        Collections.sort(humanList);
    }
    public void sortByData(){
        Collections.sort(humanList, new HumanComporator<T>());

    }



    @Override
    public String toString() {
        return "FamilyTree{" +
                "humanList=" + humanList +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<T>(humanList);
    }

}
