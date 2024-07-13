package Family_tree;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable{
    private List<Human> humanList = new ArrayList<Human>(); 
    
    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }
    public boolean add (Human human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(human.id++);

        }
        return true;
    }

    public void removeHuman(Human human) {
        humanList.remove(human);
    }

    // public void getFamilyTree() {
    //     for (Human human : humans) {
    //         System.out.println(human.name);
    //     }
    // }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Human human : humanList) {
            string.append(human.name).append("\n");
        }
        return string.toString();
    }    
}
