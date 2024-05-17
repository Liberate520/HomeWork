package Family_tree;
import java.util.ArrayList;
import java.util.List;

public class FamiliTree {
    List<Human> humans = new ArrayList<Human>();
    
    public void addHuman(Human human) {
        humans.add(human);
    }

    public void removeHuman(Human human) {
        humans.remove(human);
    }

    // public void getFamilyTree() {
    //     for (Human human : humans) {
    //         System.out.println(human.name);
    //     }
    // }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Human human : humans) {
            string.append(human.name).append("\n");
        }
        return string.toString();
    }
    
}
