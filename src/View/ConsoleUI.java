package View;

import Model.FileHandler;
import Model.Gender;
import Model.Writable;
import Presenter.Presenter;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
    }

    @Override
    public void Start(){
        System.out.println("Приветствую! Выберите действие:");
        while (work) {
            System.out.println("1. Добавить человека");
            System.out.println("2. Добавить отца");
            System.out.println("3. Добавить мать");
            System.out.println("4. Показать семейное дерево");
            System.out.println("5. Сохранить семейное дерево");
            System.out.println("6. Закончить работу");

            String line = scanner.nextLine();
            switch (line){
                case "1":
                    addHuman();
                    break;
                case "2":
                    System.out.println("Введите имя человека, которому вы хотите добавить отца: ");
                    String childName = scanner.nextLine();
                    System.out.println("Введите имя отца");
                    String fatherName = scanner.nextLine();
                    System.out.println("Введите дату рождения отца: YYYY-MM-DD");
                    LocalDate fatherDob = LocalDate.parse(scanner.nextLine());
                    Gender fatherGender = Gender.Male;
                    presenter.addFather(childName, fatherName, fatherDob, fatherGender);
                    break;
                case "3":
                    System.out.println("Введите имя человека, которому вы хотите добавить мать: ");
                    String childNameForMother = scanner.nextLine();
                    System.out.println("Введите имя матери");
                    String motherName = scanner.nextLine();
                    System.out.println("Введите дату рождения матери: YYYY-MM-DD");
                    LocalDate motherDob = LocalDate.parse(scanner.nextLine());
                    Gender motherGender = Gender.Female;
                    presenter.addMother(childNameForMother, motherName, motherDob, motherGender);
                    break;
                case "4":
                    presenter.printFamilyTree();
                    break;
                case "5":
                    save();
                case "6":
                    finish();
                default:
                    System.out.println("Введено некорректное значение");
            }
        }
    }
    public void addHuman(){
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения: YYYY-MM-DD");
        LocalDate dob = LocalDate.parse(scanner.nextLine());
        System.out.println("Укажите пол: Male/Female");
        Gender gender = Gender.valueOf(scanner.nextLine());
        presenter.addHuman(name, dob, gender);
    }


    public void printAnswer(String text){
        System.out.println(text);
    }
    public void save() {
        System.out.println("Сохранение семейного дерева...");
        presenter.save("C:\\Users\\Podgaynyy\\Desktop\\Programming\\GeekBrains\\Программист\\" +
                "Java\\OOP\\homeWork_Java_OOP\\save");
        System.out.println("Семейное дерево успешно сохранено.");
    }

    public void finish(){
        System.out.println("До новых встреч!");
        work = false;
    }
}