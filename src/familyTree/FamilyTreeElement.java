package src.familyTree;

import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeElement {
    FamilyTreeElement getSpouse();

    void setSpouse(FamilyTreeElement human);

    List<FamilyTreeElement> getParents();

    void addParent(FamilyTreeElement human);

    List<FamilyTreeElement> getChildren();

    void addChild(FamilyTreeElement human);

    int getId();

    String getName();

    int getAge();

    LocalDate getBirthDate();
}