package family_tree;

import human.Gender;

import java.time.LocalDate;

public interface FamilyTreeElement {

        String getName();
        int getAge();
        LocalDate getDob();
        Gender getGender();

}
