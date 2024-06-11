package ru.gb.famaly_tree.ft;

import ru.gb.famaly_tree.human.*;

import java.io.Serializable;
import java.util.*;

public class Famaly_tree implements Serializable, Iterable<Human> {
    private Human founder;
    private List<Human> humanList = new ArrayList<>();

    //добваление ребенка к родителю
    public void addThisInThis(Human child, Human parent){
        parent.addChild(child);
        if (parent.getGender() == Gender.male){
            child.addFather(parent);
        }
        else{
            child.addMother(parent);
        }
        addUniqueHuman(child);
        addUniqueHuman(parent);
    }

    //вывод дерева
    public String printFamalyTree(Human persona){
        Queue<Human> childrenList = new LinkedList<>();
        childrenList.add(persona);
        StringBuilder stringBuilder = new StringBuilder();
        while (!childrenList.isEmpty()){
            Human child = childrenList.remove();
            stringBuilder.append("\n");
            stringBuilder.append("У "+child.getName());
            if (!persona.getChildren().isEmpty()){
                stringBuilder.append(" дети: ");
                for (Human childchild : child.getChildren()){
                    stringBuilder.append(childchild.getName()+ " ");
                    childrenList.add(childchild);
                }
            }
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
    //добваление ключегого члена дерева
    public void addFounder(Human founderOfFamalyTree){
        founder = founderOfFamalyTree;
    }
    //возварат ключегого члена дерева
    public Human GetFounder(){
        return founder;
    }
    //создание пар
    public void coupl(Human man, Human woman){
        man.addChildren(woman.getChildren());
        for(Human child : woman.getChildren()){
            child.addFather(man);
            addUniqueHuman(child);
        }
        addUniqueHuman(man);
        addUniqueHuman(woman);
    }

    private void addUniqueHuman(Human human){
        boolean flag = true;
        if(humanList!=null) {
            for (int i = 0; i < humanList.size(); i++) {
                if (humanList.get(i) == human) {
                    flag = false;
                }
            }
            if(flag){
                humanList.add(human);
            }
        }
        else {
            humanList.add(human);
        }
    }

    public String humanListToString(){
        StringBuilder outputString = new StringBuilder();
        outputString.append("Список людей в дереве: ");
        for(Human human:humanList){
            outputString.append(human.getName()+", ");
        }
        return outputString.toString();
    }

    public String humanListToString(List<Human> humans){
        StringBuilder outputString = new StringBuilder();
        outputString.append("Список людей в дереве: ");
        for(Human human:humans){
            outputString.append(human.getName()+", ");
        }
        return outputString.toString();
    }

    public List<Human> sortByName(boolean outputNotAliveHuman){
        List<Human> humans = listIsAlive(outputNotAliveHuman);
        Collections.sort(humans, new HumanComporatorByName());
        return humans;
    }

    public List<Human> sortByAge(boolean outputNotAliveHuman){
        List<Human> humans = listIsAlive(outputNotAliveHuman);
        Collections.sort(humans,new HumanComporatorByAge());
        return humans;
    }

    public List<Human> sortByChildrenCount(boolean outputNotAliveHuman){
        List<Human> humans = listIsAlive(outputNotAliveHuman);
        Collections.sort(humans,new HumanComporatorByChildrenCount());
        return humans;
    }

    private List<Human> listIsAlive(boolean outputNotAliveHuman){
        List<Human> humans = new ArrayList<>();
        for(Human human:humanList){
            if(!human.deadOrAlive()){
                if(!outputNotAliveHuman){
                    continue;
                }
            }
            humans.add(human);
        }
        return humans;
    }


    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }
}