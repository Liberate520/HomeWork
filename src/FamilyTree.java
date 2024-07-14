import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private int id;
    private int humanId;
    private List<Human> humans;
    private List<Human> children;

    public FamilyTree(int id){
        this.id = id;
        humans = new ArrayList<>();
        children = new ArrayList<>();
    }
    public void addHuman(Human human){
        human.setId(++humanId);
        humans.add(human);
    }
    public String getHumansInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей древа:\n");
        for (Human human: humans){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
    public String getHumansChildrenInfo(int selectId) {
        children.clear();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список детей для " + humans.get(selectId-1).getName() + " :\n");

        for(Human human : humans){
            if (human.getFather() == humans.get(selectId-1)) {
                children.add(human);
            }
        }

        if (children.size() > 0){
            for (Human human : children) {
                stringBuilder.append(" - ");
                stringBuilder.append(human.getName());
                stringBuilder.append("\n");
            }
        } else{
            stringBuilder.append("Для данного человека сведений по детям нет");
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
