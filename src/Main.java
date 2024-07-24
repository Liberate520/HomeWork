import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) throws Exception {
        // Создание экземпляров класса Person с датами рождения
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Person ivan = new Person(1, "Ivan", sdf.parse("1980-01-01"), Gender.MALE);
        Person maria = new Person(2, "Maria", sdf.parse("1982-02-02"), Gender.FEMALE);
        Person deti1 = new Person(3, "Deti1", sdf.parse("2005-03-03"), Gender.MALE);
        Person deti2 = new Person(4, "Deti2", sdf.parse("2007-04-04"), Gender.FEMALE);

        // Создание экземпляра класса FamilyTree и добавление членов семьи
        FamilyTree familyTree = new FamilyTree();
        familyTree.addMember(ivan);
        familyTree.addMember(maria);
        familyTree.addMember(deti1);
        familyTree.addMember(deti2);

        // Установка родителей и детей
        familyTree.addChild(ivan, deti1);
        familyTree.addChild(ivan, deti2);
        familyTree.addChild(maria, deti1);
        familyTree.addChild(maria, deti2);

        // Создание экземпляра класса Researcher
        Researcher researcher = new Researcher();

        // Получение всех потомков
        List<Person> descendants = researcher.getDescendants(ivan);

        // Запись данных в файл
        WriterAndReader.writeToFile("family.txt", descendants);

        // Чтение данных из файла и вывод на консоль
        System.out.println("Contents of family.txt:");
        WriterAndReader.readFromFile("family.txt");

        // Вывод информации о потомках
        System.out.println("\nDescendants of Ivan:");
        for (Person descendant : descendants) {
            System.out.println(descendant);
        }
    }
}