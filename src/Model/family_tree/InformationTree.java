package Model.family_tree;

import Model.family_tree.human.Item;

import java.util.List;

public class InformationTree<C extends Item<C>> {
    private List<C> humans;
    private FamilyTree familyTree;

    public InformationTree(List<C> humans) {
        this.humans = familyTree.getHumans();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("В дереве ");
        sb.append(humans.size());
        sb.append(" объектa: ");
        sb.append("\n");
        for (C human : humans) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}
