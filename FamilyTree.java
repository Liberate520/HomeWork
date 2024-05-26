package OOP.SemDZ.homeWork;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class FamilyTree implements Serializable {
    private int idCount=0;
    private List<Human> humanTreeList;

    public FamilyTree() {
        humanTreeList = new ArrayList<>();
    }

    public void addHuman (Human human){
        idCount++;
        human.setId(idCount);
        humanTreeList.add(human);
    }

    public void wedding (Human groom, Human bride){
        groom.setSpouse(bride);
        bride.setSpouse(groom);
    }

    

       
}
