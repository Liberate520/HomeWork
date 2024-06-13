package seminar2.Human;

import java.util.List;

public abstract class TreeCreature<T extends Creature> {

    protected List<T> parents;
    protected List<T> children;
    protected T partner;

    public boolean addChild(T child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(T parent){
        if(!parents.contains(parent)){
            parents.add(parent);
            return true;
        }
        return false;
    }

    public T getFather(){
        for(T parent: parents){
            if(parent.getGender() == Gender.Male){
                return parent;
            }
        }
        return  null;
    }

    public T getMother(){
        for(T parent: parents){
            if(parent.getGender() == Gender.Female){
                return parent;
            }
        }
        return null;
    }
}
