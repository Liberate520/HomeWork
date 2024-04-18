import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Human>{


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
        }
    }

    public String MembersListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Члены семьи:\n");

        for (Human human: family) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
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

    @Override
    public Iterator<Human> iterator() {
        return new MembersIterator(family);
    }

    @Override
    public String toString() {
        return MembersListInfo();
    }

    public void sortByName() {
        family.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        family.sort(new HumanComparatorByAge());
    }
}