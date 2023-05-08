import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class FamilyTree implements Serializable{
    private List<Human> humans = new ArrayList<Human>();
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
}
