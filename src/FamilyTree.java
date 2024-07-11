import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilyTree implements Serializable {

    private final Map<String, Human> members;

    public FamilyTree() {
        this.members = new HashMap<>();
    }

    public void addMember(Human human) {
        members.put(human.getName(), human);
    }

    public Human getMember(String name) {
        return members.get(name);
    }

    public List<Human> getChildrenOf(String name) {
        Human parent = getMember(name);
        return parent != null ? parent.getChildren() : new ArrayList<>();
    }

    public List<Human> getParentsOf(String name) {
        Human child = getMember(name);
        return child != null ? child.getParents() : new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Human member : members.values()) {
            sb.append(member).append("\n");
        }
        return sb.toString();
    }

}
