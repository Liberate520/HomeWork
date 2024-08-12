import java.util.List;
import java.util.ArrayList;

public class FamilyTree {

    private List<Human> family;

    public FamilyTree() {
        family = new ArrayList<>();
    }

    public Human getByName (String name){
        for (Human human: family){
            if(human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }

    public void addHuman(Human human){
        family.add(human);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Все члены семейного древа: \n");
        for (Human human : family) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();

    }
}
