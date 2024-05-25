package family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import human.Gender;
import human.Human;

public class Tree implements Serializable {
    private List<Human> familyTree;

    public Tree() {
        this(new ArrayList<>());
    }

    public Tree(List<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public void addToTree(Human human) {
        familyTree.add(human);
    }

    public String showMen() {
        if (familyTree == null) {
            return "No info";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("Men in this family tree: ");
        for (Human human : familyTree) {
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
        for (Human human : familyTree) {
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

    public void showProgenitors(Human human) {
        System.out.println("The progenitors of " + human.getName() + " are:");
        showProgenitor(human, 0, 0);
    }

    private void showProgenitor(Human human, int depth, int count) {
        if (human.getFather() == null && human.getMother() == null) {
            return;
        } else {
            for (int i = 0; i < depth; i++) {
                System.out.print(" ");
            }
            if (count == 0) {
                System.out.print("parents: ");
            } else if (count == 1) {
                System.out.print("greatparents (" + human.getName() + "'s line): ");
            } else {
                for (int j = 0; j < count - 1; j++) {
                    System.out.print("grand-");
                }
                System.out.print("greatparents (" + human.getName() + "'s line): ");
            }
            if (human.getFather() == null) {
                System.out.print("");
            } else {
                System.out.print(human.getFather().getName() + " ");
            }
            if (human.getMother() == null) {
                System.out.print("");
            } else {
                System.out.print(human.getMother().getName() + " ");
            }
            System.out.println("");
            if (human.getFather() == null) {
                System.out.print("");
            } else {
                showProgenitor(human.getFather(), depth + 5, count + 1);
            }
            if (human.getMother() == null) {
                System.out.print("");
            } else {
                showProgenitor(human.getMother(), depth + 5, count + 1);
            }
        }
    }

    @Override
    public String toString() {

        if (familyTree == null) {
            return "No info";
        }
        StringBuilder builder = new StringBuilder();
        for (Human human : familyTree) {
            builder.append(human.getName());
            builder.append(", ");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}