import java.util.ArrayList;
import java.util.List;

class FamilyTree {
    private List<Human> humans;

    public FamilyTree() {
        humans = new ArrayList<>();
    }

    public void addHuman(Human human) {
        humans.add(human);
    }

    @Override
    public String toString() {
        for (Human human : humans) {
            return human + "\n"+ "Отец: " + (human.getFather() != null ? human.getFather().getName() : "" + "\n") + "Мать: " + (human.getMother() != null ? human.getMother().getName() : "") + "\n" + "Дети: " + formatChildrenList(human.getChildren()) + "\n";
        }
        return null;
    }

    private String formatChildrenList(List<Human> children) {
        StringBuilder childrenList = new StringBuilder();
        for (Human child : children) {
            childrenList.append(child.getName()).append(", ");
        }
        if (childrenList.length() > 0) {
            childrenList.delete(childrenList.length() - 2, childrenList.length());
        }
        return childrenList.toString();
    }
}

