package family_tree;

import human.Human;
import human.comparators.HumanComparatorByAge;
import human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeElement> implements Serializable, Iterable<E>{


    private final List<E> family;

    public FamilyTree(List<E> family) {
        this.family = family;
    }

    public FamilyTree() {
        this.family = new ArrayList<E>();
    }

    public void addMember(E member) {
        if (!(member == null) && !family.contains(member)) {
            this.family.add(member);
        }
    }

    public String MembersListInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Члены семьи:\n");

        for (E human: family) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

//    public String ChildrenInfo(E name) {
//        StringBuilder children = new StringBuilder("Все дети " + name.getName() + "\n");
//        for (E member : family) {
//            if (member.getMother() == name) {
//                children.append("------------\n");
//                children.append("Имя: ").append(member.getName()).append("\nДата рождения: ").append(member.getDob()).append("\nПол: ").append(member.getGender()).append("\n");
//            }
//        }
//        return children.toString();
//    }

    @Override
    public Iterator<E> iterator() {
        return new MembersIterator<>(family);
    }

    @Override
    public String toString() {
        return MembersListInfo();
    }

    public void sortByName() {
        family.sort(new HumanComparatorByName<>());
    }

    public void sortByAge() {
        family.sort(new HumanComparatorByAge<>());
    }
}