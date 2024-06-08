package FamilyTree.view;

import FamilyTree.model.human.Gender;
import FamilyTree.presenter.Presenter;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleUI implements View {

    private Presenter presenter;
    private Scanner scanner;
    private int work = 1;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    public String help(){
        StringBuilder sb = new StringBuilder();
        sb.append("Комманды для работы с семейным древом (Хотел спать, времени реализовать больше - не было): ");
        sb.append("\n- /help - вывести список всех комманд.");
        sb.append("\n- /createFamilyTree [Имя] - создать семейное древо.");
        sb.append("\n- /addElement - добавить элемент в древо");
        sb.append("\n- /viewFamilyTree - посмотреть таблицу");
        sb.append("\n- /setWedding - сыграть свадьбу!");
        sb.append("\n- /stop - остановить выполнение программы (ВСЕ УДАЛИТСЯ, БД не подключено)");
        return sb.toString();
    }

    public void createFamilyTree(String name){
            presenter.createFamilyTree(name);
            printAnswer("Древо создано!");
    }

    public void addElement(){
        System.out.println("Укажите имя: ");
        String name = scanner.nextLine();
        int checkCorrectGender = 1;
        int checkCorrectDate = 1;
        Gender gender = null;
        LocalDate birthDate = null;
        LocalDate deathDate = null;
        while (checkCorrectGender == 1) {
            System.out.println("Укажите гендер (1 - мужчина, 2 - женщина): ");
            int choose = Integer.parseInt(scanner.nextLine());
            if (choose == 1) {
                gender = Gender.Male;
                checkCorrectGender = 0;
            } else if (choose == 2) {
                gender = Gender.Female;
                checkCorrectGender = 0;
            } else {
                System.out.println("Гендер указан неверно.");
            }
        }
        while (checkCorrectDate == 1) {
            try {
                System.out.println("Введите дату рождения: (Корректный вод: год, месяц, день.  Пример: 2001,11,7)");
                String birthDateLine = scanner.nextLine();
                String[] birthDateMassive = birthDateLine.split(",");
                int year = Integer.parseInt(birthDateMassive[0]);
                int month = Integer.parseInt(birthDateMassive[1]);
                int day = Integer.parseInt(birthDateMassive[2]);
                birthDate = LocalDate.of(year, month, day);
                checkCorrectDate = 0;
            } catch (DateTimeParseException exception){
                System.out.println("Введен неправильный формат даты.");
            }
        }
        checkCorrectDate = 1;
        while (checkCorrectDate == 1) {
            try {
                System.out.println("Если персона умерла, введите дату смерти: (Корректный вод: год, месяц, день.  Пример: 2001,11,7)");
                System.out.println("Если персона ещё здравствует, напишите null");
                String deathDateLine = scanner.nextLine();
                if(Objects.equals(deathDateLine, "null")){
                    break;
                } else {
                    String[] deathDateMassive = deathDateLine.split(",");
                    int year = Integer.parseInt(deathDateMassive[0]);
                    int month = Integer.parseInt(deathDateMassive[1]);
                    int day = Integer.parseInt(deathDateMassive[2]);
                    deathDate = LocalDate.of(year, month, day);
                    checkCorrectDate = 0;
                }
            } catch (DateTimeParseException exception){
                System.out.println("Введен неправильный формат даты.");
            }
        }
        presenter.addElement(name, gender, birthDate, deathDate);
        System.out.println("Персона успешно добавлена в древо!");
    }

    public void setWedding(){
        System.out.println("Свадьба! Ура, создается ячейка общества.");
        System.out.println("Введите id жениха: ");
        long id1 = Long.parseLong(scanner.nextLine());
        System.out.println("Введите id невесты: ");
        long id2 = Long.parseLong(scanner.nextLine());
        System.out.println("Объявляю вас мужем и женой! Целуйтесь!");
        presenter.setWedding(id1, id2);
    }

    @Override
    public void start() {
        printAnswer("Приветствуем в программе создания древа! Это начальный вариант реализации консольного приложения. \n" +
                "Если хоите узнать список команд - напишите /help");
        while (work == 1){
            String query = scanner.nextLine();
            String[] parts = query.split(" ");
            if(parts.length > 2){
                System.out.println("Запрос неверный, введите комманду ещё раз.");
            }
            switch (parts[0]) {
                case "/help":
                    printAnswer(help());
                    break;
                case "/createFamilyTree":
                    try {
                        createFamilyTree(parts[1]);
                    } catch (ArrayIndexOutOfBoundsException exception){
                        System.out.println("Вы не указали имя древа.");
                    }
                    break;
                case "/addElement":
                    addElement();
                    break;
                case "/viewFamilyTree":
                    presenter.viewFamilyTree();
                    break;
                case "/setWedding":
                    setWedding();
                    break;
                case "/stop":
                    work = 0;
                    break;
                default: printAnswer("Комманда введена неверно!");
            }
        }
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }
}
