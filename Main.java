import java.time.LocalDate;

// import Writer.FH;
import familyTree.FamilyTree;
import familyTree.Gender;
import familyTree.Human;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human tolya = new Human("Анатолий", Gender.Мужской, LocalDate.of(2024, 5, 6), null);
        familyTree.addMember(tolya);

        Human sasha = new Human("Саша", Gender.Мужской, LocalDate.of(2000, 10, 1), null);
        Human maria = new Human("Мария", Gender.Женский, LocalDate.of(2002, 10, 25), null);
        tolya.addParent(sasha, maria);
        familyTree.addMembers(sasha, maria);
        System.out.println("Родители Толи: \n" + sasha + "\n" + maria + "\n");
        
        Human petya = new Human("Петя", Gender.Мужской, LocalDate.of(1980, 1, 25), null);
        Human mila = new Human("Мила", Gender.Женский, LocalDate.of(1981, 10, 2), null);
        sasha.addParent(mila, petya);
        familyTree.addMembers(mila, petya);
        System.out.println("Родители Саши и соответственно, Дедушка и Бабушка Толи: \n" + petya + "\n" + mila + "\n");

        Human kirill = new Human("Кирилл", Gender.Мужской, LocalDate.of(1979, 12, 29), null);
        Human olya = new Human("Оля", Gender.Женский, LocalDate.of(1978, 3, 4), null);
        maria.addParent(kirill, olya);
        familyTree.addMembers(kirill, olya);
        System.out.println("Родители Марии и соответственно, Дедушка и Бабушка Толи: \n" + kirill + "\n" + olya + "\n");

        /** Сериализация
        
        FH fileHandler = new FH();
        String fileName = "FT.txt";
        fileHandler.writeToFile(fileName, familyTree);

        Десериализация

        FamilyTree readFamilyTree = fileHandler.readFromFile(fileName);
        for (Human person : readFamilyTree.getFamily()) {
            System.out.println(person);
        }
        */
        
        familyTree.sortByAge();
        System.out.println("Сортировка по дате рождения: \n" + familyTree);

        familyTree.sortByName();
        System.out.println("Сортировка по имени: \n" + familyTree);

    }
}