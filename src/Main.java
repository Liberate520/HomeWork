import enums.Gender;
import models.FamilyTree;
import models.Human;
import services.FamilyTreeFileHandler;
import services.RelationshipSearch;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) {
        // Создание членов древа
        Human ivanRomanov = new Human("Иоанн Алексеевич Романов", Gender.MALE, LocalDate.of(1666, 9, 6), LocalDate.of(1696, 2, 8));
        Human alexeyRomanov = new Human("Алексей Михайлович Романов", Gender.MALE, LocalDate.of(1629, 3, 19), LocalDate.of(1676, 2, 8));
        Human mariaRomanova = new Human("Мария Ильинична Милославская", Gender.FEMALE, LocalDate.of(1624, 4, 11), LocalDate.of(1669, 3, 13));
        Human dmitryRomanov = new Human("Дмитрий Алексеевич Романов", Gender.MALE, LocalDate.of(1648, 11, 1), LocalDate.of(1649, 10, 16));
        Human evdokiaRomanova = new Human("Евдокия Алексеевна Романова", Gender.FEMALE, LocalDate.of(1650, 2, 17), LocalDate.of(1712, 5, 10));
        Human praskovyaRomanova = new Human("Прасковья Фёдоровна Салтыкова", Gender.FEMALE, LocalDate.of(1664, 10, 22), LocalDate.of(1723, 10, 24));
        Human mariaRomanova2 = new Human("Мария Ивановна Романова", Gender.FEMALE, LocalDate.of(1689, 3, 31), LocalDate.of(1692, 2, 23));
        Human feodosiaRomanova = new Human("Феодосия Ивановна Романова", Gender.FEMALE, LocalDate.of(1690, 6, 14), LocalDate.of(1691, 5, 22));
        Human ekaterina1Romanova = new Human("Екатерина Иоанновна Романова", Gender.FEMALE, LocalDate.of(1691, 11, 8), LocalDate.of(1733, 6, 25));
        Human annaRomanova = new Human("Анна Иоанновна Романова", Gender.FEMALE, LocalDate.of(1693, 2, 7), LocalDate.of(1740, 10, 28));
        Human praskovya1Romanova = new Human("Прасковья Иоанновна Романова", Gender.FEMALE, LocalDate.of(1694, 10, 4), LocalDate.of(1731, 10, 19));

        // Создание генеалогического древа
        FamilyTree familyTree = new FamilyTree();

        // Установка родителей для детей
        familyTree.setParents(ivanRomanov, Arrays.asList(alexeyRomanov, mariaRomanova));
        familyTree.setParents(dmitryRomanov, Arrays.asList(alexeyRomanov, mariaRomanova));
        familyTree.setParents(evdokiaRomanova, Arrays.asList(alexeyRomanov, mariaRomanova));
        familyTree.setParents(mariaRomanova2, Arrays.asList(ivanRomanov, praskovyaRomanova));
        familyTree.setParents(feodosiaRomanova, Arrays.asList(ivanRomanov, praskovyaRomanova));
        familyTree.setParents(ekaterina1Romanova, Arrays.asList(ivanRomanov, praskovyaRomanova));
        familyTree.setParents(annaRomanova, Arrays.asList(ivanRomanov, praskovyaRomanova));
        familyTree.setParents(praskovya1Romanova, Arrays.asList(ivanRomanov, praskovyaRomanova));

        // Установка брачных отношений
        familyTree.setSpouse(ivanRomanov, praskovyaRomanova);

        // Поиск родственных связей
        List<Human> children = familyTree.getChildren(ivanRomanov);
        List<Human> parents = familyTree.getParents(ivanRomanov);
        Human spouse = familyTree.getSpouse(ivanRomanov);
        List<Human> siblings = familyTree.getSiblings(ivanRomanov);

        // Вывод информации о Иоанне Алексеевиче Романове
        System.out.println(ivanRomanov);
        System.out.println("Отец: " + parents.get(0));
        System.out.println("Мать: " + parents.get(1));
        System.out.println("Братья/Сестры:");
        for (Human sibling : siblings) {
            System.out.println(" - " + sibling);
        }
        System.out.println("Супруга: " + spouse);
        System.out.println("Дети:");
        for (Human child : children) {
            System.out.println(" - " + child);
        }

        // Сохранение и загрузка генеалогического древа
        FamilyTreeFileHandler.saveToFile(familyTree, "family_tree.dat");
        FamilyTree loadedTree = FamilyTreeFileHandler.loadFromFile("family_tree.dat");
    }
}