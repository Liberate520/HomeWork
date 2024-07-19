package Part3_OOP.Seminar1.Family_tree;

/** Получить родителей до 2 колена от выбранного человека */

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human tolya = new Human("Анатолий", Gender.Male, LocalDate.of(2024, 5, 6), null);

        Human sasha= new Human("Саша", Gender.Male, LocalDate.of(2000, 10, 1), null);
        Human maria = new Human("Мария", Gender.Female, LocalDate.of(2002, 10, 25), null);

        Human petya = new Human("Петя", Gender.Male, LocalDate.of(1980, 1, 25), null);
        Human mila = new Human("Мила", Gender.Female, LocalDate.of(1981, 10, 2), null);
        Human kirill = new Human("Кирилл", Gender.Male, LocalDate.of(1979, 12, 29), null);
        Human olya = new Human("Оля", Gender.Female, LocalDate.of(1978, 3, 4), null);

        tolya.addParent(sasha);
        tolya.addParent(maria);

        sasha.addParent(mila);
        sasha.addParent(petya);
        
        maria.addParent(kirill);
        maria.addParent(olya);

        familyTree.addMember(tolya);
        familyTree.addMember(sasha);
        familyTree.addMember(maria);
        familyTree.addMember(petya);
        familyTree.addMember(mila);
        familyTree.addMember(kirill);
        familyTree.addMember(olya);

        System.out.println("Родители Толи до 2 поколения:");
        for (Human ancestor : familyTree.getAncestors(tolya, 2)) {
            System.out.println("Родители Анатолия: " + ancestor.getName());
        }
    }
}