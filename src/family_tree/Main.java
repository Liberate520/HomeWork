package family_tree;

import java.time.LocalDate;

import static java.time.LocalDate.of;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human johnWilliams = new Human("John Williams", of(1978, 10, 15), Gender.Male, null, null);
        Human maryBass = new Human("Mary Williams", of(1988, 12, 20), Gender.Female, null, null);

        familyTree.addMember(johnWilliams);
        familyTree.addMember(maryBass);

        Human thomasWilliams = new Human("Thomas Williams ", of(1998, 6, 12), Gender.Male, johnWilliams, maryBass);
        Human stellaWilliams  = new Human("Stella Williams ", of(2002, 8, 22), Gender.Female, johnWilliams, maryBass);

        johnWilliams.addChild(thomasWilliams );
        johnWilliams.addChild(stellaWilliams );
        maryBass.addChild(thomasWilliams );
        maryBass.addChild(stellaWilliams );

        familyTree.addMember(thomasWilliams );
        familyTree.addMember(stellaWilliams );

        System.out.println();
        for (Human child : familyTree.getChildrenOf(maryBass)) {
            System.out.println(child);
        }
    }
}
