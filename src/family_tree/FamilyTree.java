package family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humans;

    public FamilyTree() {
        this.humans = new ArrayList<>();
    }

    /**
     * Добавление человека в древо (если человек уже присутствует, то он не добавляется)
     * @param human Человек
     */
    public void addHuman(Human human){
        if(!humans.contains(human)){
            humans.add(human);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Фамильное древо:\n");

        stringBuilder.append("-----------------\n");
        for (Human human : humans) {
            stringBuilder.append("\t" + human);
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
