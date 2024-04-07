import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    private List<Human> family;

    public FamilyTree() {
        this.family = new ArrayList<Human>();
    }

    public void addMember(Human member) {
        this.family.add(member);
    }

    public String allMembers() {
        StringBuilder output = new StringBuilder("Члены семьи:\n");
        for (Human member : family) {
            output.append("------------\n");
            output.append("Имя: ").append(member.getName()).append("\nДата рождения: ").append(member.getDob()).append("\nПол: ").append(member.getGender()).append("\n");
        }
        return output.toString();
    }

    public String allChildren(Human name) {
        StringBuilder children = new StringBuilder("Дети " + name.getName() + "\n");
        for (Human member : family) {
            if (member.getMother() == name) {
                children.append("------------\n");
                children.append("Имя: ").append(member.getName()).append("\nДата рождения: ").append(member.getDob()).append("\nПол: ").append(member.getGender()).append("\n");
            }
        }
        return children.toString();
    }
}