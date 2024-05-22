import family_tree.FamilyTree;
import human.Gender;
import human.Human;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // указываем путь к файлу
        String filePatch = "src/familyTree.txt";
        // Создаем и наполняем семейное дерево
//        FamilyTree dyatchini = createsFamilyTree();
        // Наполняем семейное дерево
        FamilyTree dyatchini = load(filePatch);
        // Демонстраци работы дерева
        demonstratesfamilyTree(dyatchini);
        // Сохранение дерева в файл
//        save(dyatchini, filePatch);
    }

    /**
     * Демонстрирует возможности классов проекта
     * @param familyTree
     */
    private static void demonstratesfamilyTree(FamilyTree familyTree) {
        // находим и печатаем Алису
        System.out.println(familyTree.findFirsIn("Алиса"));
        printSeparator();
        // находим и печатаем всех с фамилией шадрин
        System.out.println(familyTree.findFirsAll("Шадрин"));
        printSeparator();
        // Узнаем возраст Ярослава
        System.out.println(familyTree.findFirsIn("Ярослав").getAge());
        printSeparator();
        // Узнаем родителей Натальи
        System.out.println(familyTree.findFirsIn("Наталья").getParents());
        printSeparator();
        // Узнаем детей Ольги
        System.out.println(familyTree.findFirsIn("Ольга").getChildren());
        printSeparator();
        // узнаем бабушек и дедушек Ярослава
        System.out.println(familyTree.findFirsIn("Ярослав").getGrandparents());
        printSeparator();
        // Узнаем внуков Александра
        System.out.println(familyTree.findFirsIn("Александр").getGrandsons());
        printSeparator();
        // Печатаем краткое дерево
        System.out.println(familyTree);
        printSeparator();
        // Печатаем полное дерево через пустой поиск
        System.out.println(familyTree.findFirsAll(""));
        printSeparator();
    }

    /**
     *   Создает и наплняет экземпляр класса family_tree.FamilyTree  экзеплярами класса human.Human с заданными данными.
     *   Устанавливает родственные связи.
     * @return FamilyTree
     */
    private static FamilyTree createsFamilyTree () {
        // СОздаем семейное дерево
        FamilyTree familyTree = new FamilyTree(new ArrayList<>());
        // Создаем людей на примере моей семьи
        Human dyatchinYS = new Human("Дятчин Ярослав Сергеевич", Gender.Male, "2013-10-09");
        Human dyatchinaAS = new Human("Дятчина Алиса Сергеевна", Gender.Female, "2008-03-05");
        Human dyatchinSA = new Human("Дятчин Сергей Александрович", Gender.Male,"1983-01-16");
        Human dyatchinaNV = new Human("Дятчина Наталья Владимировна", Gender.Female,"1984-11-11");
        Human dyatchinAA = new Human("Дятчин Александр Алесандрович", Gender.Male,"1961-10-19", "2012-05-22");
        Human dyatchinaTV = new Human("Дятчина Татьяна Васильевна", Gender.Female,"1959-09-27", "1991-07-16");
        Human shadrinVK = new Human("Шадрин Владимир Кузмич", Gender.Male,"1954-04-30");
        Human shadrinaOI = new Human("Шадрина Ольга Ивановна", Gender.Female,"1954-04-29");
        // Добаляем членов семьи
        familyTree.addHuman(dyatchinYS);
        familyTree.addHuman(dyatchinaAS);
        familyTree.addHuman(dyatchinaNV);
        familyTree.addHuman(dyatchinAA);
        familyTree.addHuman(dyatchinaTV);
        familyTree.addHuman(shadrinVK);
        familyTree.addHuman(shadrinaOI);
        // Устанавливаем связи  родителей (дети добавляются автоматически приватным методом)
        dyatchinYS.setParents(dyatchinaNV, dyatchinSA);
        dyatchinaAS.setParents(dyatchinaNV, dyatchinSA);
        dyatchinSA.setParents(dyatchinaTV, dyatchinAA);
        dyatchinaNV.setParents(shadrinaOI, shadrinVK);
        return familyTree;
    }

    /**
     * Печатает разделить ввидеде 40 дефисов в одну строку и переводит строку
     */
    private static void printSeparator () {
        for (int i = 0; i < 40 ; i++) {
            System.out.print("-");
        }
        System.out.println("\n");
    }

    /**
     * Сохраняет дерево как объект в файл
     * @param familyTree
     * @param filePatch
     */
    private static void save(FamilyTree familyTree, String filePatch) {
        Writable writable = new FileHandler();
        writable.save(familyTree, filePatch);
    }

    /**
     * Загружает объект из файла и приводит его к типу FamilyTree
     * @param filePatch
     * @return
     */
    private static FamilyTree load(String filePatch) {
        Writable writable = new FileHandler();
        return (FamilyTree) writable.load(filePatch);
    }
}
