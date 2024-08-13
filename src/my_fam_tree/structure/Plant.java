package my_fam_tree.structure;

import java.util.List;
import java.util.stream.Collectors;

public class Plant implements IPlant {
    private FamilyTree familyTree;

        public Plant(FamilyTree familyTree) {
            this.familyTree = familyTree;
        }

        @Override
        public List<Human> getChildren(String name) {
            Human human = familyTree.findHuman(name);
            return human != null ? human.getChildren(): null;
        }

        @Override
        public Human[] getParents(String name) {
            Human human = familyTree.findHuman(name);
            if (human != null) {
                return new Human[]{(Human) human.getFather(), (Human) human.getMother()};
            }
            return null;
        }

        @Override
        public List<Human> getSiblings(String name) {
            Human human = familyTree.findHuman(name);
            if (human != null) {
                Human father = human.getFather();
                Human mother = human.getMother();
                if (father != null) {
                    return father.getChildren().stream()
                            .filter(child -> !child.equals(human))
                            .collect(Collectors.toList());
                } else if (mother != null) {
                    return mother.getChildren().stream()
                            .filter(child -> !child.equals(human))
                            .collect(Collectors.toList());
                }
            }
            return null;
        }
    }
