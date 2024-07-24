import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    private List<Human> familyMembers = new ArrayList<>();

    public void addHuman(Human human) {
        familyMembers.add(human);
    }

    public void setParentChildRelationship(Human parent, Human child) {
        parent.addChild(child);
        child.addParent(parent);
    }

    public void printFamilyRelationships() {
        for (Human human : familyMembers) {
            System.out.println("Человек: " + human.name + " (родился: " + human.birthDate + ")");
            if (!human.parents.isEmpty()) {
                System.out.print("Родители: ");
                for (Human parent : human.parents) {
                    System.out.print(parent.name + " (родился: " + parent.birthDate + ")");
                    if (parent.deathDate != null) {
                        System.out.print(", умер: " + parent.deathDate);
                    }
                    System.out.print(") ");

                }

                System.out.println();
                if (!human.children.isEmpty()) {
                    System.out.print("Дети: ");
                    for (Human child : human.children) {
                        System.out.print(child.name + " (родился: " + child.birthDate);
                    }
                    System.out.print(") ");
                }
                System.out.println();
                System.out.println();
            }
        }


        var sb = new StringBuilder();
        for (Human human : familyMembers) {
            sb.append(human.name).append(", ");
        }

    }
}


