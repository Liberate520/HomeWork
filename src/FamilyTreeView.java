import java.util.List;

public interface FamilyTreeView<T extends FamilyMember> {
    void displayMember(T member);
    void displayMembers(List<T> members);
    void displayMessage(String message);
    void showMenu();
}