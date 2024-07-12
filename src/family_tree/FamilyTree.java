package family_tree;


import human.Comparator1;
import human.Comparator2;
import human.Gender;
import human.Human;
import java.io.Serializable;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

 public class FamilyTree implements Serializable,Iterable<Human>{

    private List<Human> humans;
    private int humansId;






    public FamilyTree(List<Human> humanList) {
        this.humans = humanList;



    }




    public FamilyTree() {
        this(new ArrayList<>());

    }


     public boolean add(Human human){

         if (human==null){
             return false;
         }
         if (!humans.contains(human)){
             humans.add(human);
             addToParents(human);
             addToChildren(human);
             return true;
         }
         return false;
     }

     public List<Human> getHumans() {
         return humans;
     }

     private void addToParents(Human human){
        for (Human parent :human.getParents()){
            parent.addChild(human);
        }

    }
    private  void  addToChildren(Human human){
        for (Human child :human.getChildren()){
            child.addParent(human);
        }
    }
    public List<Human> getSiblings(int id){
        Human human = getById(id);

        if (human==null){
            return null;
        }
        List<Human> siblings = new ArrayList<>();
        for (Human parent: human.getParents())
        {
            for (Human child: human.getChildren()){
                if (!child.equals(human)){
                    siblings.add(child);
                }
            }
        }

        return siblings;
    }
    public Human getById(int id) {
        for (Human human : humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public boolean setWedding(Human human1, Human human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }



     public boolean setFamily(int id1, int id2) {
        Human human1 = getById(id1);
        Human human2 = getById(id2);
        if (!human2.getParents().contains(human1)) {

            human1.addChild(human2);
            human2.addParent(human1);
            return true;
        }
        else {
            return false;
        }
    }
    public void SortByName(){
        Collections.sort(humans,new Comparator2());
    }
     public void SortByBrthDate(){
         Collections.sort(humans,new Comparator1());
     }

     @Override
     public Iterator<Human> iterator() {
         return humans.iterator();
     }


    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("В дереве ");
        sb.append(humans.size());
        sb.append(" объектa: ");
        sb.append("\n");
        for (Human human : humans) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

}
