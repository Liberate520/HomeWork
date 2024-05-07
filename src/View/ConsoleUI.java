package View;
import Service.FamilyTreeService;
import Model.Gender;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private FamilyTreeService service;

    public ConsoleUI(FamilyTreeService service) {
        this.scanner = new Scanner(System.in);
        this.service = service;
    }

    @Override
    public void Start() {
        System.out.println("Приветствую! Выберите действие:");
        String line;
        while (true) {
            System.out.println("1. Добавить человека");
            System.out.println("2. Добавить отца");
            System.out.println("3. Добавить мать");
            System.out.println("4. Показать семейное дерево");
            System.out.println("5. Сохранить семейное дерево");
            System.out.println("6. Закончить работу");

            line = scanner.nextLine();
            switch (line) {
                case "1":
                    addHuman();
                    break;
                case "2":
                case "3":
                    addParent(line);
                    break;
                case "4":
                    service.printFamilyTree();
                    break;
                case "5":
                    service.saveTree("C:\\Users\\Podgaynyy\\Desktop\\Programming\\GeekBrains\\Программист\\" +
                            "Java\\OOP\\homeWork_Java_OOP\\save");
                    break;
                case "6":
                    System.out.println("До новых встреч!");
                    return;
                default:
                    System.out.println("Введено некорректное значение");
            }
        }
    }

    private void addHuman() {
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения: YYYY-MM-DD");
        LocalDate dob = LocalDate.parse(scanner.nextLine());
        System.out.println("Укажите пол: Male/Female");
        Gender gender = Gender.valueOf(scanner.nextLine());
        service.addHuman(name, dob, gender);
    }

    private void addParent(String choice) {
        System.out.println("Введите имя человека, которому вы хотите добавить " + (choice.equals("2") ? "отца" : "мать") + ": ");
        String childName = scanner.nextLine();
        System.out.println("Введите имя " + (choice.equals("2") ? "отца" : "матери"));
        String parentName = scanner.nextLine();
        System.out.println("Введите дату рождения: YYYY-MM-DD");
        LocalDate dob = LocalDate.parse(scanner.nextLine());
        Gender gender = choice.equals("2") ? Gender.Male : Gender.Female;

        if (choice.equals("2")) {
            service.addFather(childName, parentName, dob, gender);
        } else {
            service.addMother(childName, parentName, dob, gender);
        }
    }


    @Override
    public void printAnswer(String text) {

    }

    @Override
    public void save() {

    }
}