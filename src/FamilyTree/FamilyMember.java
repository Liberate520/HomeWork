package FamilyTree;


import java.time.LocalDate;
import java.util.List;

public interface FamilyMember {
    List<FamilyMember> getParents();

    List<FamilyMember> getChildrenList ();

    void addParents(FamilyMember parent);
    void addChildren(FamilyMember child);

    LocalDate getDob();
    String getName();
}
