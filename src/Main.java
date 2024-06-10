import models.Human;
import models.FamilyTree;
import services.FamilyTreeFileHandler;
import services.RelationshipSearch;
import utils.List;
import enums.Gender;

public class Main {
    public static void main(String[] args) {
        // Создание объектов класса Human
        Human ioann = new Human("Иоанн Алексеевич Романов", "06.09.1666", "08.02.1696", Gender.MALE);
        Human alexey = new Human("Алексей Михайлович Романов", "19.03.1629", "8.02.1676", Gender.MALE);
        Human maria = new Human("Мария Ильинична Милославская", "11.04.1624", "13.03.1669", Gender.FEMALE);
        Human dmitry = new Human("Дмитрий Алексеевич Романов", "01.11.1648", "16.10.1649", Gender.MALE);
        Human evdokia = new Human("Евдокия Алексеевна Романова", "17.02.1650", "10.05.1712", Gender.FEMALE);
        Human praskovya = new Human("Прасковья Фёдоровна Салтыкова", "22.10.1664", "24.10.1723", Gender.FEMALE);
        Human mariaIvanovna = new Human("Мария Ивановна Романова", "31.03.1689", "23.02.1692", Gender.FEMALE);
        Human feodosia = new Human("Феодосия Ивановна Романова", "14.06.1690", "22.05.1691", Gender.FEMALE);
        Human ekaterina = new Human("Екатерина Иоанновна Романова", "8.11.1691", "25.06.1733", Gender.FEMALE);
        Human anna = new Human("Анна Иоанновна Романова", "07.02.1693", "28.10.1740", Gender.FEMALE);
        Human praskovyaIoannovna = new Human("Прасковья Иоанновна Романова", "04.10.1694", "19.10.1731", Gender.FEMALE);

        // Создание объекта класса FamilyTree
        FamilyTree<Human> familyTree = new FamilyTree<>();

        // Добавление объектов в дерево
        familyTree.add(ioann);
        familyTree.add(alexey);
        familyTree.add(maria);
        familyTree.add(dmitry);
        familyTree.add(evdokia);
        familyTree.add(praskovya);
        familyTree.add(mariaIvanovna);
        familyTree.add(feodosia);
        familyTree.add(ekaterina);
        familyTree.add(anna);
        familyTree.add(praskovyaIoannovna);

        // Установка родственных связей
        ioann.setMother(maria);
        ioann.setFather(alexey);
        dmitry.setMother(maria);
        dmitry.setFather(alexey);
        evdokia.setMother(maria);
        evdokia.setFather(alexey);
        mariaIvanovna.setMother(praskovya);
        mariaIvanovna.setFather(ioann);
        feodosia.setMother(praskovya);
        feodosia.setFather(ioann);
        ekaterina.setMother(praskovya);
        ekaterina.setFather(ioann);
        anna.setMother(praskovya);
        anna.setFather(ioann);
        praskovyaIoannovna.setMother(praskovya);
        praskovyaIoannovna.setFather(ioann);

        // Вывод неотсортированных данных
        System.out.println("Родственные связи:");
        for (Human human : familyTree) {
            System.out.println(human);
        }

        // Вывод сортированных данных по имени
        System.out.println("\nСортированный по имени:");
        List<Human> sortedByName = new RelationshipSearch().sortByName(familyTree);
        for (Human human : sortedByName) {
            System.out.println(human);
        }

        // Вывод сортированных данных по дате рождения
        System.out.println("\nСортированный по дате рождения:");
        List<Human> sortedByBirthDate = new RelationshipSearch().sortByBirthDate(familyTree);
        for (Human human : sortedByBirthDate) {
            System.out.println(human);
        }

        // Сохранение данных в файл
        FamilyTreeFileHandler fileHandler = new FamilyTreeFileHandler();
        fileHandler.saveFamilyTree(familyTree, "family_tree.txt");

        // Чтение данных из файла
        FamilyTree<Human> loadedFamilyTree = fileHandler.loadFamilyTree("family_tree.txt");

        // Вывод загруженных данных
        System.out.println("\nЗагруженные данные:");
        for (Human human : loadedFamilyTree) {
            System.out.println(human);
        }
    }
}