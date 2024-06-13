import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private long humanID;
    private List<Human> humanList;
    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public void add(Human human){
        if(!humanList.contains(human)){
            humanList.add(human);
            human.setID(humanID++);
            addToCildren(human);
            addToMother(human);
            addToFather(human);
        }
    }
    // заимствовал, но по-своему
    private void addToCildren(Human human){ // добавляем человека родителем к его детям если его там нет.
        for (Human child: human.getChildren()){
            if(human.getGender() == Gender.Female){
                child.setMother(human);
            } else {
                child.setFather(human);
            }
        }
    }
    private void addToMother(Human human){
        if(human.getMother()!=null) {
            human.getMother().addChildToList(human);
        }
    }
    private void addToFather(Human human){
        if(human.getFather()!=null) {
            human.getFather().addChildToList(human);
        }
    }
    public String getAllInfo() {
        StringBuilder str = new StringBuilder();
        for(Human human: humanList){
            str.append(human.getInfo() + "\n");
        }
        return str.toString();
    }


}
