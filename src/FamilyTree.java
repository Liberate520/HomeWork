

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree  implements Serializable {
    static List<Human> humans = new ArrayList<>();
    public static void addHuman(Human human){
        humans.add(human);
        if(human.getMother() != null){
            human.getMother().addChild(human);
        }
        if(human.getFather() != null){
            human.getFather().addChild(human);
        }
    }



    public static String getHumansInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Древо состоит из ");
        stringBuilder.append(humans.size());
        stringBuilder.append(" человек:\n");
        for (Human human: humans){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
