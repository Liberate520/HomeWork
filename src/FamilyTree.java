

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree  implements Serializable, Iterable<Human> {
    private final List<Human> humans;
    public FamilyTree(){this(new ArrayList<>()); }
    public FamilyTree(List<Human> humans){this.humans = humans;}
    public void addHuman(Human human){
        humans.add(human);
        if(human.getMother() != null){
            human.getMother().addChild(human);
        }
        if(human.getFather() != null){
            human.getFather().addChild(human);
        }
    }


    public String getHumansInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Древо состоит из ");
        stringBuilder.append(humans.size());
        stringBuilder.append(" человек:\n");
        for (Human human: humans){
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        humans.sort(new HumanComparatorByName());
    }
    public void sortByBirthDate(){
        humans.sort(new HumanComparatorByBirthDate());
    }

    @Override
    public @NotNull Iterator<Human> iterator() {
        return new FamilyTreeIterator(humans);
    }
}
