import java.util.List;
import java.util.stream.Collectors;

public class Plant implements IPlant {
    private FamilyTree familyTree;

        public Plant(FamilyTree familyTree) {
            this.familyTree = familyTree;
        }

        @Override
        public List<Human> getChildren(String name) {
            HumanAbsract human = familyTree.findHuman(name);
            if (human != null) {
                return human.getChildren().stream()
                        .map(child -> (Human) child)
                        .collect(Collectors.toList());
            }
            return null;
        }

        @Override
        public Human[] getParents(String name) {
            HumanAbsract human = familyTree.findHuman(name);
            if (human != null) {
                return new Human[]{(Human) human.getFather(), (Human) human.getMother()};
            }
            return null;
        }

        @Override
        public List<Human> getSiblings(String name) {
            HumanAbsract human = familyTree.findHuman(name);
            if (human != null) {
                HumanAbsract father = human.getFather();
                HumanAbsract mother = human.getMother();
                if (father != null) {
                    return father.getChildren().stream()
                            .filter(child -> !child.equals(human))
                            .map(child -> (Human) child)
                            .collect(Collectors.toList());
                } else if (mother != null) {
                    return mother.getChildren().stream()
                            .filter(child -> !child.equals(human))
                            .map(child -> (Human) child)
                            .collect(Collectors.toList());
                }
            }
            return null;
        }
    }
