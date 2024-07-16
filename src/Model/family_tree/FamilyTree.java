package Model.family_tree;


import Model.family_tree.human.ComparatorByBrthDate;
import Model.family_tree.human.ComparatorByName;
import Model.family_tree.human.ComporatorById;

import java.io.Serializable;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

 public class FamilyTree<C extends Item<C>> implements Serializable,Iterable<C>{

    private List<C> humans;
    private int humansId;






    public FamilyTree(List<C> humanList) {
        this.humans = humanList;



    }




    public FamilyTree() {
        this(new ArrayList<>());

    }


     public boolean add(C human){

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

     public List<C> getHumans() {
         return humans;
     }

     private void addToParents(C human){
        for (C parent :human.getParents()){
            parent.addChild(human);
        }

    }
    private  void  addToChildren(C human){
        for (C child :human.getChildren()){
            child.addParent(human);
        }
    }
    public List<C> getSiblings(int id){
        C human = getById(id);

        if (human==null){
            return null;
        }
        List<C> siblings = new ArrayList<>();
        for (C parent: human.getParents())
        {
            for (C child: human.getChildren()){
                if (!child.equals(human)){
                    siblings.add(child);
                }
            }
        }

        return siblings;
    }
    public C getById(int id) {
        for (C human : humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public boolean setWedding(C human1, C human2) {
        if (human1.getSpouse() == null && human2.getSpouse() == null) {
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else {
            return false;
        }
    }



     public boolean setFamily(int id1, int id2) {
        C human1 = getById(id1);
        C human2 = getById(id2);
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
        Collections.sort(humans,new ComparatorByName<>());
    }
     public void SortByBrthDate(){
         Collections.sort(humans,new ComparatorByBrthDate<>());
     }
     public void sortById() {
         Collections.sort(humans, new ComporatorById<>());
     }

     @Override
     public Iterator<C> iterator() {
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
        for (C human : humans) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

}
