import Comparator.HumanComparatorByGender;
import Comparator.HumanComparatorByName;
import Humans.Human;


import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;



public class FamilyTree implements Serializable, Iterable{
    private List<Human> humans = new ArrayList<>();
    private OutAndInputInfo outAndInputInfo =new OutAndInputInfo();

    public void addHuman(Human human){
        humans.add(human);
    }
    public Human getHuman(String name, String surname){
        for(Human human: humans){
            if(human.getName().equals(name) && human.getSurname().equals(surname)){
                return human;
            }

        }
        return null;


    }
    public String getHumanInfo(Human human){
        return human.toString();
    }

    public void saveHuman(Human inputHuman){
        String name = inputHuman.getName();
        outAndInputInfo.WriteInfo(inputHuman, name);
    }

    public Human readHuman(String name){
        return outAndInputInfo.ReadInfo(name);
    }

    public List humansPrint(){
        return humans;
    }

    public List humanSort(){
        Collections.sort(humans);
        return humans;
    }

    public List humanSortByName(){
        Collections.sort(humans, new HumanComparatorByName());
        return humans;
    }


    public List humanSortByGender(){
        Collections.sort(humans, new HumanComparatorByGender());
        return humans;
    }


    @Override
    public Iterator<Human> iterator() {
        return humans.iterator();
    }
}
