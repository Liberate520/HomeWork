package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.SpouseStatus;
import ru.gb.family_tree.writer.FileHandler;

import java.time.LocalDate;

/**
 * Основной класс приложения для работы с семейным древом.
 * <p>
 * В классе {@code Main} демонстрируются основные операции с семейным древом:
 * создание, сортировка, запись и чтение из файлов.
 * </p>
 */
public class Main {
    /**
     * Основной метод приложения.
     * <p>
     * В методе выполняются следующие действия:
     * <ul>
     *     <li>Инициализация путей к файлам для записи и чтения данных.</li>
     *     <li>Создание и заполнение экземпляра {@code FamilyTree} данными.</li>
     *     <li>Вывод данных семейного древа до записи в файлы.</li>
     *     <li>Сортировка и вывод данных по имени и возрасту.</li>
     *     <li>Запись данных в файлы.</li>
     *     <li>Чтение данных из файлов и вывод восстановленных данных.</li>
     * </ul>
     * </p>
     *
     * @param args Массив аргументов командной строки.
     */
    public static void main(String[] args) {
        // Адреса файла для записи/чтения:
        String path1 = "src/ru/gb/family_tree/writer/family_tree_sorted_by_name.out";
        String path2 = "src/ru/gb/family_tree/writer/family_tree_sorted_by_age.out";

        // Инициализация экземпляра класса для записи/чтения:
        FileHandler fileHandler = new FileHandler();

        // Инициализация экземпляра класса семейного древа:
        FamilyTree<Human> familyTree = testTree();

        System.out.println("\nДанные из семейного древа ДО чтения из файла:\n");
        System.out.println(familyTree);

        System.out.println("---------");
        System.out.println("Sorted by Name:\n");

        familyTree.sortByName();
        System.out.println(familyTree);

        // Запись в файл:
        fileHandler.write(familyTree, path1);

        System.out.println("Sorted by Age:\n");

        familyTree.sortByAge();
        System.out.println(familyTree);

        // Запись в файл:
        fileHandler.write(familyTree, path2);

        // Чтение из файла:
        FamilyTree<Human> familyTreeRestored1 = (FamilyTree<Human>) fileHandler.read(path1);
        System.out.println("\nДанные из семейного древа c сортировкой по имени\nПОСЛЕ чтения из файла:\n");
        System.out.println(familyTreeRestored1);

        // Чтение из файла:
        FamilyTree<Human> familyTreeRestored2 = (FamilyTree<Human>) fileHandler.read(path2);
        System.out.println("\nДанные из семейного древа c сортировкой по возрасту\nПОСЛЕ чтения из файла:\n");
        System.out.println(familyTreeRestored2);
    }

    /**
     * Создает и заполняет тестовое семейное древо данными.
     * <p>
     * Создает экземпляры {@code Human}, связывает их в семейные отношения и добавляет их в {@code FamilyTree}.
     * </p>
     *
     * @return Заполненное тестовое семейное древо.
     */
    static FamilyTree<Human> testTree() {
        FamilyTree<Human> familyTree = new FamilyTree<>();

        Human human1 = new Human("Ермолов Вадим Викторович", Gender.male, LocalDate.of(1981, 5, 29));
        Human human2 = new Human("Ермолова Нурия Айдаровна", Gender.female, LocalDate.of(1981, 3, 17));
        Human human3 = new Human("Ермолов Виктор Семенович", Gender.male, LocalDate.of(1958, 6, 3));
        Human human4 = new Human("Ермолова Залия Мухаматсакиевна", Gender.female, LocalDate.of(1960, 3, 18));
        Human human5 = new Human("Абдррахманов Айдар Хабибуллович", Gender.male, LocalDate.of(1960, 12, 1));
        Human human6 = new Human("Абдрахманова Фарида Кинягалиевна", Gender.female, LocalDate.of(1960, 12, 26), LocalDate.of(2007, 4, 15));

        human1.setFather(human3);
        human1.setMother(human4);
        human2.setFather(human5);
        human2.setMother(human6);
        human3.addChild(human1);
        human4.addChild(human1);
        human1.addSpouse(human2, SpouseStatus.Actual);
        human2.addSpouse(human1, SpouseStatus.Actual);
        human3.addSpouse(human4, SpouseStatus.Actual);
        human4.addSpouse(human3, SpouseStatus.Actual);
        human5.addSpouse(human6, SpouseStatus.Actual);
        human6.addSpouse(human5, SpouseStatus.Actual);

        familyTree.addMember(human1);
        familyTree.addMember(human2);
        familyTree.addMember(human3);
        familyTree.addMember(human4);
        familyTree.addMember(human5);
        familyTree.addMember(human6);

        return familyTree;
    }
}
