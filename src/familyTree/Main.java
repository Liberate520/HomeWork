package familyTree;

import familyTree.familyTree.FamilyTree;
import familyTree.human.Gender;
import familyTree.human.People;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree ivanov = new FamilyTree();
        People ivan = new People("Иван", Gender.Male, LocalDate.of(1966, 02, 25));
        People masha = new People("Маша", Gender.Female, LocalDate.of(1970, 11, 10));
        ivanov.add(ivan);
        ivanov.add(masha);

        People dmitriy = new People("Дмитрий", Gender.Male, LocalDate.of(1988, 07, 15), masha, ivan);
        ivanov.add(dmitriy);
        System.out.println(ivanov);
    }
}
