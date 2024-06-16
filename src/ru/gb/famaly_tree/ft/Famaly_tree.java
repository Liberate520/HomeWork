package ru.gb.famaly_tree.ft;

import ru.gb.famaly_tree.human.*;

import java.io.Serializable;
import java.util.*;

public class Famaly_tree<T extends DutiesOfTheCreature<T>> implements Serializable, Iterable<T> {
    private T founder;
    private List<T> humanList = new ArrayList<>();

    //добваление ребенка к родителю
    public void addThisInThis(T child, T parent){
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
    public String printFamalyTree(T persona){
        Queue<T> childrenList = new LinkedList<>();
        childrenList.add(persona);
        StringBuilder stringBuilder = new StringBuilder();
        while (!childrenList.isEmpty()){
            T child = childrenList.remove();
            stringBuilder.append("\n");
            stringBuilder.append("У "+child.getName());
            if (!persona.getChildren().isEmpty()){
                stringBuilder.append(" дети: ");
                for (T childchild : child.getChildren()){
                    stringBuilder.append(childchild.getName()+ " ");
                    childrenList.add(childchild);
                }
            }
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
    //добваление ключегого члена дерева
    public void addFounder(T founderOfFamalyTree){
        founder = founderOfFamalyTree;
    }
    //возварат ключегого члена дерева
    public T GetFounder(){
        return founder;
    }
    //создание пар
    public void coupl(T man, T woman){
        man.addChildren(woman.getChildren());
        for(T child : woman.getChildren()){
            child.addFather(man);
            addUniqueHuman(child);
        }
        addUniqueHuman(man);
        addUniqueHuman(woman);
    }

    private void addUniqueHuman(T human){
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
        for(T human:humanList){
            outputString.append(human.getName()+", ");
        }
        return outputString.toString();
    }

    public String humanListToString(List<T> humans){
        StringBuilder outputString = new StringBuilder();
        outputString.append("Список людей в дереве: ");
        for(T human:humans){
            outputString.append(human.getName()+", ");
        }
        return outputString.toString();
    }

    public List<T> sortByName(boolean outputNotAliveHuman){
        List<T> humans = listIsAlive(outputNotAliveHuman);
        Collections.sort(humans, new HumanComporatorByName());
        return humans;
    }

    public List<T> sortByAge(boolean outputNotAliveHuman){
        List<T> humans = listIsAlive(outputNotAliveHuman);
        Collections.sort(humans,new HumanComporatorByAge());
        return humans;
    }

    public List<T> sortByChildrenCount(boolean outputNotAliveHuman){
        List<T> humans = listIsAlive(outputNotAliveHuman);
        Collections.sort(humans,new HumanComporatorByChildrenCount());
        return humans;
    }

    private List<T> listIsAlive(boolean outputNotAliveHuman){
        List<T> humans = new ArrayList<>();
        for(T human:humanList){
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
    public Iterator<T> iterator() {
        return new HumanIterator(humanList);
    }
}