package FamillyTree;
import Human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree  implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<Human> familyMembers = new ArrayList<>();

    public void addHuman(Human human) {
        familyMembers.add(human);
    }

    public void setParentChildRelationship(Human parent, Human child) {
        parent.addChild(child);
        child.addParent(parent);
    }

    public void printFamilyRelationships() {
        for (Human human : familyMembers) {
            System.out.println("�������: " + human.getName() + " (�������: " + human.getBirthDate() + ")");
            if (!human.parents.isEmpty()) {
                System.out.print("��������: ");
                for (Human parent : human.parents) {
                    System.out.print(parent.getName() + " (�������: " + parent.getBirthDate() + ")");
                    if (parent.getDeathDate() != null) {
                        System.out.print(", ����: " + parent.getDeathDate());
                    }
                    System.out.print(") ");
                }
                System.out.println();
                if (!human.children.isEmpty()) {
                    System.out.print("����: ");
                    for (Human child : human.children) {
                        System.out.print(child.getName() + " (�������: " + child.getBirthDate() + ")");
                    }
                    System.out.print(") ");
                }
                System.out.println();
                System.out.println();
            }
        }
    }

}

