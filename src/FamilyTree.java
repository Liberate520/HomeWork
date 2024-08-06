import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class FamilyTree<T extends FamilyMember> implements Serializable, Iterable<T> {
    private static final long serialVersionUID = 1L;
    private Map<String, T> members;

    public FamilyTree() {
        this.members = new HashMap<>();
    }

    public void addMember(T member) {
        members.put(member.getId(), member);
    }

    public T getMemberById(String id) {
        return members.get(id);
    }

    public List<T> getMemberByName(String name) {
        return members.values().stream()
                .filter(member -> member.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<T> getAllChildren(String id) {
        T member = getMemberById(id);
        return member != null ? (List<T>) member.getChildren() : new ArrayList<>();
    }

    public List<T> getAllMembers() {
        return new ArrayList<>(members.values());
    }

    @Override
    public Iterator<T> iterator() {
        return members.values().iterator();
    }

    public List<T> sortByAge(Comparator<T> comparator) {
        return members.values().stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public List<T> sortByGender(Comparator<T> comparator) {
        return members.values().stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}