package ru.gb.famaly_tree.model.ft;

import ru.gb.famaly_tree.model.human.DutiesOfTheCreature;
import ru.gb.famaly_tree.model.human.Gender;
import ru.gb.famaly_tree.model.human.Human;
import ru.gb.famaly_tree.model.human.comporators.HumanComporatorByAge;
import ru.gb.famaly_tree.model.human.comporators.HumanComporatorByChildrenCount;
import ru.gb.famaly_tree.model.human.comporators.HumanComporatorByName;

import java.io.Serializable;
import java.util.*;

public abstract class Famaly_Tree_Abstract<T extends DutiesOfTheCreature<T>> implements Serializable, Iterable<T> {
    private T founder;
    private List<T> humanList = new ArrayList<>();
    private List<List<T>> couplList = new ArrayList<>();

    //добваление ребенка к родителю
    public void addChildToParent(T child, T parent){
        parent.addChild(child);
        if (parent.getGender() == Gender.male){
            child.addFather(parent);
            T mother = findSpouse(parent);
            if(mother!=null){
                child.addMother(mother);
                mother.addChild(child);
            }
        }
        else{
            child.addMother(parent);
            T father = findSpouse(parent);
            if(father!=null){
                child.addMother(father);
                father.addChild(child);
            }
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
            if(findSpouse(child)!=null){
                stringBuilder.append(" и " + findSpouse(child).getName());
            }
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
        humanList.add(founderOfFamalyTree);
    }
    //возварат ключегого члена дерева
    public T GetFounder(){
        return founder;
    }
    //создание пар
    public void coupl(T man, T woman){
        List<T> temporaryHumanList = man.getChildren();
        man.addChildren(woman.getChildren());
        woman.addChildren(temporaryHumanList);

        for(T child : woman.getChildren()){
            child.addFather(man);
            addUniqueHuman(child);
        }

        for(T child : temporaryHumanList){
            child.addMother(woman);
            addUniqueHuman(child);
        }

        addUniqueHuman(man);
        addUniqueHuman(woman);

        List<T> temporaryCouplList = new ArrayList<>();
        temporaryCouplList.add(man);
        temporaryCouplList.add(woman);
        couplList.add(temporaryCouplList);
    }

    public List<List<T>> outputCouplList(){
        return couplList;
    }

    public Human searchByName(String name){
        for(int i =0; i<humanList.size();i++){
            //System.out.println(name+"__"+humanList.get(i).getName());
            if (humanList.get(i).getName().equals(name)){
                return (Human) humanList.get(i);
            }
        }
        return null;
    }

    private T findSpouse(T human){
        for(int i = 0; i<couplList.size(); i++){
            if (couplList.get(i).get(0).equals(human)){
                return (T) couplList.get(i).get(1);
            }
            else if (couplList.get(i).get(1).equals(human)) {
                return (T) couplList.get(i).get(0);
            }
        }
        return null;
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