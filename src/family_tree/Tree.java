package family_tree;

// import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import human.Gender;
import human.Human;

public class Tree {
    Human human;
    List<Human> familyTree;

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
        System.out.println(showProgenitor(human));
    }

    private String showProgenitor(Human human) {
        StringBuilder builder = new StringBuilder();
        if (human.getFather() == null && human.getMother() == null) {
            return builder.toString();
        } else {
            builder.append("- parents of ");
            builder.append(human.getName());
            builder.append(": ");
            if (human.getFather() == null) {
                builder.append("");
            } else {
                builder.append(human.getFather().getName());
                builder.append(" ");
            }
            if (human.getMother() == null) {
                builder.append("");
            } else {
                builder.append(human.getMother().getName());
            }
            builder.append("\n");
            if (human.getFather() == null) {
                builder.append("");
            } else {
                builder.append(showProgenitor(human.getFather()));
            }
            builder.append("");
            if (human.getMother() == null) {
                builder.append("");
            } else {
                builder.append(showProgenitor(human.getMother()));
            }
        }
        return builder.toString();
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