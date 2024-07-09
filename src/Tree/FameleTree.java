package Tree;

import Human.Human;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FameleTree {
    public int humanId;
    public HashMap<Integer, Human> humanList;
    public String secondName;

    public FameleTree(String secondName) {
        this.secondName = secondName;
        this.humanId=0;
        this.humanList = new HashMap<>();
    }

    public boolean add(Human human) {
        if (human.getId()==humanId){
            return false;
        }

        else {
            humanList.put(humanId,human);
            human.setId(humanId);
            humanId++;
            return true;
        }
    }
    public boolean addParents (int idHuman, Human father, Human mother){
        if(father.getGender() == mother.getGender()){
            return false;
        }
        else {
            add(mother);
            add(father);
            Human parentsAdd =  humanList.get(idHuman);
            String newInformationAboutPerson = STR."\{parentsAdd.getNameAndGenderString()}. Отец: \{father.getName()}. Мать: \{mother.getName()}";
            parentsAdd.setInformationsAboutPerson(newInformationAboutPerson);

            return true;
        }
    }


    public void printTree() {
        for (Map.Entry<Integer, Human> entry : humanList.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());

        }

    }
}
