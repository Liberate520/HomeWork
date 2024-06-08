import models.FamilyTree;
import models.Human;
import services.RelationshipSearch;
import services.FamilyTreeFileHandler;
import enums.Gender;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        try {
            // Создаем дерево
            FamilyTree familyTree = new FamilyTree();

            // Добавляем людей в дерево
            Human ioannAlexeievich = new Human("Иоанн Алексеевич Романов", LocalDate.of(1666, 9, 6), LocalDate.of(1696, 2, 8), Gender.MALE);
            Human alexeyMikhailovich = new Human("Алексей Михайлович Романов", LocalDate.of(1629, 3, 19), LocalDate.of(1676, 2, 8), Gender.MALE);
            Human mariaIljinichna = new Human("Мария Ильинична Милославская", LocalDate.of(1624, 4, 11), LocalDate.of(1669, 3, 13), Gender.FEMALE);
            Human praskovyaFedorovna = new Human("Прасковья Фёдоровна Салтыкова", LocalDate.of(1664, 10, 22), LocalDate.of(1723, 10, 24), Gender.FEMALE);

            // Добавляем родственников
            ioannAlexeievich.addMother(mariaIljinichna);
            ioannAlexeievich.addFather(alexeyMikhailovich);
            alexeyMikhailovich.setSpouse(praskovyaFedorovna);

            // Добавляем детей
            Human mariaIvanovna = new Human("Мария Ивановна Романова", LocalDate.of(1689, 3, 31), LocalDate.of(1692, 2, 23), Gender.FEMALE);
            Human feodosiyaIvanovna = new Human("Феодосия Ивановна Романова", LocalDate.of(1690, 6, 14), LocalDate.of(1691, 5, 22), Gender.FEMALE);
            Human ekaterinaIoannovna = new Human("Екатерина Иоанновна Романова", LocalDate.of(1691, 11, 8), LocalDate.of(1733, 6, 25), Gender.FEMALE);
            Human annaIoannovna = new Human("Анна Иоанновна Романова", LocalDate.of(1693, 2, 7), LocalDate.of(1740, 10, 28), Gender.FEMALE);
            Human praskovyaIoannovna = new Human("Прасковья Иоанновна Романова", LocalDate.of(1694, 10, 4), LocalDate.of(1731, 10, 19), Gender.FEMALE);

            ioannAlexeievich.addChild(mariaIvanovna);
            ioannAlexeievich.addChild(feodosiyaIvanovna);
            ioannAlexeievich.addChild(ekaterinaIoannovna);
            ioannAlexeievich.addChild(annaIoannovna);
            ioannAlexeievich.addChild(praskovyaIoannovna);

            // Добавляем всех людей в дерево
            familyTree.addHuman(ioannAlexeievich);
            familyTree.addHuman(alexeyMikhailovich);
            familyTree.addHuman(mariaIljinichna);
            familyTree.addHuman(praskovyaFedorovna);
            familyTree.addHuman(mariaIvanovna);
            familyTree.addHuman(feodosiyaIvanovna);
            familyTree.addHuman(ekaterinaIoannovna);
            familyTree.addHuman(annaIoannovna);
            familyTree.addHuman(praskovyaIoannovna);

            // Создаем файловый хандлер
            FamilyTreeFileHandler fileHandler = new FamilyTreeFileHandler();

            // Сохраняем дерево в файл
            fileHandler.saveToFile(familyTree, "family_tree.ser");

            // Читаем дерево из файла
            FamilyTree loadedTree = fileHandler.loadFromFile("family_tree.ser");

            // Восстанавливаем связи между людьми после десериализации
            loadedTree.restoreRelationships();

            // Выводим не сортированный список
            System.out.println("Не сортированный:");
            for (Human human : loadedTree.getHumans().values()) {
                System.out.println(human.toString());
            }

            // Выводим сортированный список по имени
            System.out.println("\nСортированный по имени:");
            loadedTree.getHumans().values().stream()
                    .sorted(Comparator.comparing(Human::getName))
                    .forEach(System.out::println);

            // Выводим сортированный список по дате рождения
            System.out.println("\nСортированный по дате рождения:");
            loadedTree.getHumans().values().stream()
                    .sorted(Comparator.comparing(Human::getDateOfBirth))
                    .forEach(System.out::println);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        }
    }
}
