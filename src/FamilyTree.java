import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {


    private final List<Human> family;

    public FamilyTree(List<Human> family) {
        this.family = family;
    }

    public FamilyTree() {
        this.family = new ArrayList<Human>();
    }

    public void addMember(Human member) {
        if (!(member == null) && !family.contains(member)) {
            this.family.add(member);

            //addToChildren(member);
            //addToParents(member);
        }
    }

    public String MembersInfo() {
        StringBuilder output = new StringBuilder("Все члены семьи:\n");
        for (Human member : family) {
            output.append("------------\n");
            output.append("Имя: ").append(member.getName()).append("\nДата рождения: ").append(member.getDob()).append("\nПол: ").append(member.getGender()).append("\n");
        }
        return output.toString();
    }

    public String ChildrenInfo(Human name) {
        StringBuilder children = new StringBuilder("Все дети " + name.getName() + "\n");
        for (Human member : family) {
            if (member.getMother() == name) {
                children.append("------------\n");
                children.append("Имя: ").append(member.getName()).append("\nДата рождения: ").append(member.getDob()).append("\nПол: ").append(member.getGender()).append("\n");
            }
        }
        return children.toString();
    }

    /*
    private void addToParents(Human human) {
        for (Human parent: human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human) {
        for (Human child: human.getChildren()) {
            child.addParent(human);
        }
    }
     */
}