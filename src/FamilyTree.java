import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyTree {
    private List<Human> familyTree = new ArrayList<>();

    @Override
    public String toString() {
        return printList(familyTree);
    }

    public void add(Human human) {
        familyTree.add(human);
    }

    public static String printList(List<Human> list) {
        return list.stream()
                .map(Human::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
