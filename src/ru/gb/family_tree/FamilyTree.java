package ru.gb.family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private long idHuman;
    private List<Human> listHuman;

    public FamilyTree(List<Human> listHuman) {
        this.listHuman = listHuman;
    }
    public FamilyTree(){
        this(new ArrayList<>());
    }


    public boolean add(Human human) {
        if (human==null){
            return false;
        }
        if (!listHuman.contains(human)){
            listHuman.add(human);
            human.setId(idHuman++);

            addToParens(human);
            //addToChildren(human);

            return true;
        }
        return false;
    }


    public void addToParens(Human human) {
        for (Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    public void addToChildren(Human human) {
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }

    public List<Human> findByName(String name) {
        List<Human> result = new ArrayList<>();

        for (Human human: listHuman){
           if (human.getFirstName().equals(name)){
               result.add(human);
           }
        }

        return result;
    }

   public Human getById(long id){
       for (Human human: listHuman){
         if (human.getId()==id){
             return human;
           }
       }
       return null;
   }
   //список братьев и сестер
    public List<Human> geSistAndBr(long id){
        Human human = getById(id);
        if (human==null){
            return null;
        }

        List<Human> result = new ArrayList<>();
        for (Human parent: human.getParents()){

            for (Human child: parent.getChildren()) {
                if (!child.equals(human)){
                    result.add(child);
                }

            }
        }

        return result;

    }

    public boolean setWedding(long idHuman1, long idHuman2){
        if (checkId(idHuman1)&&checkId(idHuman2)){
            Human hum1=getById(idHuman1);
            Human hum2=getById(idHuman2);
            setWedding(hum1, hum2);
            return true;
        } else{
            return false;
        }


    }

    private boolean checkId(long id){
        return id < idHuman && id>=0;

    }
    public boolean setWedding(Human human1, Human human2){
        if(human1.getSpouse()==null && human2.getSpouse()==null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        } else{
            return false;
        }

    }

    @Override
    public String toString() {
        StringBuilder sorse = new StringBuilder();
        sorse.append("В семейном древе ");
        sorse.append(listHuman.size());
        sorse.append(" объекта.");
        sorse.append("\n");
        for (Human hum: listHuman) {
            sorse.append(hum);
            sorse.append("\n");
        }
        return sorse.toString();
    }
}
