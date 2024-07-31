package family_tree.family_tree;
import family_tree.human.Human;
import family_tree.human.HumanComparatorByDOB;
import family_tree.human.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human> {
    private int id;
    private int humanId;
    private List<Human> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }

    public void addHuman(Human human) {
        human.setId(++humanId);
        humans.add(human);
    }


    public String getHumansChildrenInfo(int selectId) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список детей для " + humans.get(selectId - 1).getName() + " :\n");
        for (Human human : humans) {
            if (human.getFather() == humans.get(selectId - 1)) {
                stringBuilder.append(" - ");
                stringBuilder.append(human.getName());
                stringBuilder.append("\n");
            }
        }


        //stringBuilder.append("Для данного человека сведений по детям нет");
        // stringBuilder.append("\n");

        return stringBuilder.toString();
    }
    public void sortByName(){
        humans.sort(new HumanComparatorByName());
    }
    public void sortByDOB(){
        humans.sort(new HumanComparatorByDOB());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humans);
    }

}