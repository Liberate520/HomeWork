package homeWork;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
;


public class FamilyTree implements Serializable {
    private List<Human> familyTree = new ArrayList<Human>();



    public void addHuman(Human human ){
        familyTree.add(human);
    }


    public String getFamilyTree(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список членов семьи:\n");
        for (Human human : familyTree){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void removeHuman(Human human){
        familyTree.remove(human);
    }





}