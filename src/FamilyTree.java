import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> listHuman;

    public FamilyTree() {
        listHuman =new ArrayList<>();
        }
    public void  addHuman (Human human){
        listHuman.add(human);
    }

//    public List<Human> getListHuman() {
//        return listHuman;
//    }
//
//    public void setListHuman(List<Human> listHuman) {
//        this.listHuman = listHuman;
//    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Генеалогическое древо\n");
        for (Human human: listHuman){
            stringBuilder.append(human);
            stringBuilder.append("\n");
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }

}
