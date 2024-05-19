import family_tree.FamilyTree;
import family_tree.Gender;
import family_tree.Human;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree(); //Создаем дерево

        //Первая промать
        Human commonMother = new Human("Марина",
                new Date(1812 - 1900, Calendar.APRIL, 10),
                new Date(1891 - 1900, Calendar.MAY, 12),
                Gender.Female);

        //Первый проотец
        Human commonFather = new Human("Вадим",
                new Date(1810 - 1900, Calendar.MAY, 15),
                new Date(1888 - 1900, Calendar.JUNE, 12),
                Gender.Male);

        Human human1 = new Human("Сергей",
                commonMother,
                commonFather,
                new Date(1824 - 1900, 6, 23),
                new Date(1901 - 1900, 7, 27),
                Gender.Male);

        commonMother.addChild(human1);
        commonFather.addChild(human1);

        familyTree.addHuman(commonMother);
        familyTree.addHuman(commonFather);
        familyTree.addHuman(human1);

        System.out.println(familyTree);
    }
}
