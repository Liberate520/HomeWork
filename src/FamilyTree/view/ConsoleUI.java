package FamilyTree.view;

import FamilyTree.model.element.Gender;
import FamilyTree.presenter.Presenter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class ConsoleUI implements View {

    private final Map<String, Command> commands = new HashMap<>();
    private final Presenter<?> presenter;
    private final Scanner scanner;
    private int work = 1;
    HelpListCommand helpListCommand = new HelpListCommand();

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter<>(this);
    }

    public void printHelp() {
        String answer = helpListCommand.help();
        printAnswer(answer);
    }

    public void createFamilyTree(){
        System.out.println("Введите название нового древа: ");
        presenter.createFamilyTree(scanner.nextLine());
        printAnswer("Древо создано!");
    }

    public void addElement(){
        System.out.println("Укажите имя: ");
        String name = scanner.nextLine();
        int checkCorrectGender = 1;
        int checkCorrectDate = 1;
        int checkCorrectChildren = 1;
        Gender gender = null;
        LocalDate birthDate = null;
        LocalDate deathDate = null;
        List children = new ArrayList<>();
        while (checkCorrectGender == 1) {
            try {
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
            } catch (Exception exception){
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
            } catch (DateTimeException | ArrayIndexOutOfBoundsException | NumberFormatException exception){
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
        System.out.println("Если известен отец - введите его id.");
        Long fatherId;
        try {
            fatherId = Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException exception){
            fatherId = null;
            System.out.println("ID не распознан. Передано пустое значение!");
        }
        System.out.println("Если известна мама - введите её id.");
        Long motherId;
        try {
            motherId = Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException exception){
            motherId = null;
            System.out.println("ID не распознан. Передано пустое значение!");
        }
        System.out.println("Если известна супруг(а) - введите его(её) id.");
        Long spouseId;
        try {
            spouseId = Long.parseLong(scanner.nextLine());
        } catch (NumberFormatException exception){
            spouseId = null;
            System.out.println("ID не распознан. Передано пустое значение!");
        }
        System.out.println("Если известны дети - введите их id по одному. Если хотите завершить добавление напишите stop");
        while (checkCorrectChildren == 1){
            String query = scanner.nextLine();
            if(query.equals("stop")){
                checkCorrectChildren = 0;
            } else {
                try {
                    long childrenId = Long.parseLong(query);
                    children.add(presenter.searchById(childrenId));
                } catch (Exception exception){
                    System.out.println("Введен неверный ID");
                }
            }
        }
        presenter.addElement(name, gender, birthDate, deathDate, fatherId, motherId, children, spouseId);
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

    public void load() throws IOException, ClassNotFoundException {
        System.out.println("Введите название древа, которое вы хотите загрузить: ");
        try {
            presenter.load(scanner.nextLine());
            System.out.println("Древо загружено!");
        } catch (FileNotFoundException exception){
            System.out.println("Такого древа не сохранено.");
        }
    }

    public void save() throws IOException {
        presenter.save();
        System.out.println("Текущее древо сохранено!");
    }

    public void viewFamilyTree(){
        System.out.println(presenter.viewFamilyTree());
    }

    public void sortedByAge(){
        System.out.println("Элементы древа успешно отсортированы по возрасту.");
        presenter.sortedByAge();
    }

    public void sortedByName(){
        System.out.println("Элементы древа успешно отсортированы по имени.");
        presenter.sortedByName();
    }

    public void searchByName(){
        System.out.println("Инициализирован поиск по имени, введите имя: ");
        System.out.println(presenter.searchByName(scanner.nextLine()));
    }

    public void searchById(){
        System.out.println("Инициализирован поиск по id, введите id элемента: ");
        System.out.println(presenter.searchById(Long.parseLong(scanner.nextLine())));
    }

    public void addParent(){
        System.out.println("Вы хотите добавить родителя ребенку, введите ID родителя: ");
        long idParent = Long.parseLong(scanner.nextLine());
        System.out.println("Введите id ребенка: ");
        long idChild = Long.parseLong(scanner.nextLine());
        presenter.addParent(idChild, idParent);
    }

    public void addChild(){
        System.out.println("Вы хотите добавить ребенка родителю, введите ID родителя: ");
        long idParent = Long.parseLong(scanner.nextLine());
        System.out.println("Введите id ребенка: ");
        long idChild = Long.parseLong(scanner.nextLine());
        presenter.addChild(idChild, idParent);
    }

    public void initializeCommands() {
        commands.put("/help", this::printHelp);
        commands.put("/createFamilyTree", this::createFamilyTree);
        commands.put("/addElement", this::addElement);
        commands.put("/viewFamilyTree", this::viewFamilyTree);
        commands.put("/setWedding", this::setWedding);
        commands.put("/save", this::save);
        commands.put("/load", this::load);
        commands.put("/sortedByName", this::sortedByName);
        commands.put("/sortedByAge", this::sortedByAge);
        commands.put("/searchByName", this::searchByName);
        commands.put("/searchById", this::searchById);
        commands.put("/addParent", this::addParent);
        commands.put("/addChild", this::addChild);
        commands.put("/stop", () -> work = 0);
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        initializeCommands();
        printAnswer("Приветствуем в программе создания древа! Это начальный вариант реализации консольного приложения. \n" +
                "Если хоите узнать список команд - напишите /help");
        while (work == 1){
            String query = scanner.nextLine();
            String[] parts = query.split(" ");
            if(parts.length > 2){
                System.out.println("Запрос неверный, введите комманду ещё раз.");
                continue;
            }
            Command command = commands.get(parts[0]);
            if (command != null) {
                try {
                    command.execute();
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                printAnswer("Комманда введена неверно!");
            }
        }
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }
}
