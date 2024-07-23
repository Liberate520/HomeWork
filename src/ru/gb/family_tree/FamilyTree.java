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

    @Override
    public String toString() {
        StringBuilder sorse = new StringBuilder();
        sorse.append("В семейном древе ");
        sorse.append(listHuman.size());
        sorse.append(" объектов.");
        return sorse.toString();
    }
}
