import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создание семейного древа
        FamilyTree tree = new FamilyTree();

        // Создание людей
        HumanInfo viserys = new HumanInfo("Viserys", LocalDate.of(1970, 1, 1), null, Gender.MALE);
        HumanInfo aemma = new HumanInfo("Aemma", LocalDate.of(1975, 5, 10), LocalDate.of(2020, 10, 1), Gender.FEMALE);
        HumanInfo alisanta = new HumanInfo("Alisanta", LocalDate.of(1990, 3, 15), null, Gender.FEMALE);
        HumanInfo rhaenyra = new HumanInfo("Rhaenyra", LocalDate.of(1996, 4, 20), null, Gender.FEMALE);
        HumanInfo aegon = new HumanInfo("Aegon", LocalDate.of(2000, 5, 25), null, Gender.MALE);
        HumanInfo aemond = new HumanInfo("Aemond", LocalDate.of(2002, 6, 30), null, Gender.MALE);
        HumanInfo helaena = new HumanInfo("Helaena", LocalDate.of(2004, 7, 15), null, Gender.FEMALE);

        viserys.addChild(rhaenyra); //родительские связи
        viserys.addChild(aegon);
        viserys.addChild(aemond);
        viserys.addChild(helaena);

        aemma.addChild(rhaenyra);

        alisanta.addChild(aegon);
        alisanta.addChild(aemond);
        alisanta.addChild(helaena);

        // Добавление людей в дерево
        tree.addPerson(viserys);
        tree.addPerson(aemma);
        tree.addPerson(alisanta);
        tree.addPerson(rhaenyra);
        tree.addPerson(aegon);
        tree.addPerson(aemond);
        tree.addPerson(helaena);

        //List<HumanInfo> childrenOfViserys = tree.getChildrenOfPerson("Viserys");

        // Вывод результатов исследования
        //System.out.println("Children of Viserys:");
        //for (HumanInfo child : childrenOfViserys) {
        //    System.out.println(child.getName() + ", DOB: " + child.getDob() + ", DOD: " + (child.getDod() != null ? child.getDod() : "N/A") + ", Gender: " + child.getGender());
        //}

        // Сохранение семейного древа в файл
        FileHandler fileHandler = new FileHandler();
        String filePath = "FamilyTree.txt";
        try {
            fileHandler.save(tree.getPeople(), filePath);
            System.out.println("Family tree saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save family tree: " + e.getMessage());
        }

        // Загрузка семейного древа из файла
        try {
            List<HumanInfo> loadedPeople = fileHandler.load(filePath);
            FamilyTree loadedTree = new FamilyTree();
            for (HumanInfo person : loadedPeople) {
                loadedTree.addPerson(person);
            }
            System.out.println("Family tree loaded successfully.");

            // Проведение исследования: получение всех детей Viserys
            List<HumanInfo> childrenOfViserys = loadedTree.getChildrenOfPerson("Viserys");

            // Вывод результатов исследования
            System.out.println("Children of Viserys:");
            for (HumanInfo child : childrenOfViserys) {
                System.out.println(child.getName() + ", DOB: " + child.getDob() +
                        ", DOD: " + (child.getDod() != null ? child.getDod() : "N/A") +
                        ", Gender: " + child.getGender());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Failed to load family tree: " + e.getMessage());
        }
    }
}