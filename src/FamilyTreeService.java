import model.FamilyTree;
import model.HumanComparatorByBirthDate;
import model.HumanComparatorByName;

import java.util.Collections;

public class FamilyTreeService {

    public void sortByName(FamilyTree familyTree) {
        Collections.sort(familyTree.getMembers(), new HumanComparatorByName());
    }

    public void sortByBirthDate(FamilyTree familyTree) {
        Collections.sort(familyTree.getMembers(), new HumanComparatorByBirthDate());
    }

}
