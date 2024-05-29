package family_tree_app.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import family_tree_app.human.Gender;
import family_tree_app.human.comparators.ComparatorByAge;
import family_tree_app.human.comparators.ComparatorByAmountOfChildren;
import family_tree_app.human.comparators.ComparatorByName;

public class Tree<T extends FamilyTreeEntry<T>> implements Serializable, Iterable<T> {
    private List<T> familyTree;

    public Tree() {
        this(new ArrayList<>());
    }

    public Tree(List<T> familyTree) {
        this.familyTree = familyTree;
    }

    public void addToTree(T human) {
        familyTree.add(human);
    }

    public String showMen() {
        if (familyTree == null) {
            return "No info";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("Men in this family tree: ");
        for (T human : familyTree) {
            if (human.getGender() == Gender.Male) {
                builder.append(human.getName());
                builder.append(", ");
            }
        }
        if (builder.length() == 0) {
            return "No men in this family tree";
        } else {
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
            return builder.toString();
        }
    }

    public String showWomen() {
        if (familyTree == null) {
            return "No info";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("Women in this family tree: ");
        for (T human : familyTree) {
            if (human.getGender() == Gender.Female) {
                builder.append(human.getName());
                builder.append(", ");
            }
        }
        if (builder.length() == 0) {
            return "No women in this family tree";
        } else {
            builder.deleteCharAt(builder.length() - 1);
            builder.deleteCharAt(builder.length() - 1);
            return builder.toString();
        }
    }

    // public void showProgenitors(Human human) {
    //     System.out.println("The progenitors of " + human.getName() + " are:");
    //     showProgenitor(human, 0, 0);
    // }

    // private void showProgenitor(Human human, int depth, int count) {
    //     if (human.getFather() == null && human.getMother() == null) {
    //         return;
    //     } else {
    //         for (int i = 0; i < depth; i++) {
    //             System.out.print(" ");
    //         }
    //         if (count == 0) {
    //             System.out.print("parents: ");
    //         } else if (count == 1) {
    //             System.out.print("greatparents (" + human.getName() + "'s line): ");
    //         } else {
    //             for (int j = 0; j < count - 1; j++) {
    //                 System.out.print("grand-");
    //             }
    //             System.out.print("greatparents (" + human.getName() + "'s line): ");
    //         }
    //         if (human.getFather() == null) {
    //             System.out.print("");
    //         } else {
    //             System.out.print(human.getFather().getName() + " ");
    //         }
    //         if (human.getMother() == null) {
    //             System.out.print("");
    //         } else {
    //             System.out.print(human.getMother().getName() + " ");
    //         }
    //         System.out.println("");
    //         if (human.getFather() == null) {
    //             System.out.print("");
    //         } else {
    //             showProgenitor(human.getFather(), depth + 5, count + 1);
    //         }
    //         if (human.getMother() == null) {
    //             System.out.print("");
    //         } else {
    //             showProgenitor(human.getMother(), depth + 5, count + 1);
    //         }
    //     }
    // }

    @Override
    public String toString() {

        if (familyTree == null) {
            return "No info";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("This family tree contains:\n");
        for (T human : familyTree) {
            builder.append(" - ");
            builder.append(human.getName());
            builder.append(" (");
            if (human.getDateOfDeath() != null) {
                builder.append("died at the age of ");
            }
            if (human.getAge() > 120) {
                builder.append("unknown age");
            } else {
                builder.append(human.getAge());
                builder.append(" y.o.");
            }
            if (human.getDateOfDeath() != null) {
                builder.append(", had ");
            } else {
                builder.append(", has ");
            }
            builder.append(human.getChildren().size());
            builder.append(" child(ren))\n");
        }
        return builder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<>(familyTree);
    }

    public void sortByName() {
        familyTree.sort(new ComparatorByName<>());
    }

    public void sortByAge() {
        familyTree.sort(new ComparatorByAge<>());
    }

    public void sortByAmountOfChildren() {
        familyTree.sort(new ComparatorByAmountOfChildren<>());
    }
}