import FamiliTree.FamilyTree;
import Human.Gender;
import Human.Human;

import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


//        System.out.println(Arrays.toString(Gender.values()));     // проверка вывода формата Gender
//        Gender gender = Gender.Female;
//        System.out.println(gender);


        FamilyTree familyTree = new FamilyTree();

        Human stepan = new Human("Stepan", Gender.Male, LocalDate.of(1951, 10, 03), LocalDate.of(2015, 07, 23), null, null);
        Human valentina = new Human("Valentina", Gender.Female, LocalDate.of(1953, 9, 11));
        Human natasha = new Human("Natasha", Gender.Female, LocalDate.of(1960, 12, 22), LocalDate.of(2021, 1, 21), null, null, null);
        familyTree.addHuman(stepan);
        familyTree.addHuman(valentina);
        familyTree.addHuman(natasha);

        Human olga = new Human("Olga", Gender.Female, LocalDate.of(1984, 12, 17));
        familyTree.addHuman(olga);

        olga.setMother(natasha);

        System.out.println(familyTree);


    }

}

// в main отобразить, как работать с проектом. Создать классы и отобразить, как с ними работать (взаимодействовать)
// Внести несколько людей. Добавить в семейное древо
// Вывести, найти информацию о каком-то человеке