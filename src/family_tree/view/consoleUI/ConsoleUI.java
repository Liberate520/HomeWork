package family_tree.view.consoleUI;

import family_tree.model.help_classes.Gender;
import family_tree.pesenter.HumanPresenter;
import family_tree.view.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class ConsoleUI implements View {
    private Scanner scanner;
    private boolean work;
    private HumanPresenter humanPresenter;
    private MainMenu menu;
    String filePath = "src/family_tree/model/saving_data/data.out";

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.work = true;
        humanPresenter = new HumanPresenter(this);
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        loadData();
        while (work) {
            System.out.println(menu.showMenu());
            execute();
        }

    }

    private void loadData() {
        humanPresenter.loadDataFile(filePath);
    }

    private void execute() {
        String line = scanner.nextLine();
        if (!isCorrectChoice(line)) return;
        int choice = Integer.parseInt(line);
        menu.execute(choice);
    }

    private boolean isCorrectChoice(String line) {
        if (!line.matches("[0-9]+")) return false;
        int choice = Integer.parseInt(line);
        if (choice > menu.getSize()) return false;
        return true;
    }

    public void saveDataFile() {
        humanPresenter.saveDataFile(filePath);
    }

    public void sortByName() {
        humanPresenter.sortByName();
    }

    public void sortByBirthDate() {
        humanPresenter.sortByBirthDate();
    }

    public void findByDocument() {
        String doc = getDocument();
        humanPresenter.findByDocument(doc);
    }

    public void findByName() {
        String name = getName();
        humanPresenter.findByName(name);
    }

    public void registerDeath() {
        String doc = getDocument();
        LocalDate date = getDate();
        humanPresenter.registerDeath(doc, date);
    }

    public void addFamilyLink() {
        System.out.println("Ребёнок: ");
        String childDoc = getDocument();
        System.out.println("Родитель: ");
        String parentDoc = getDocument();
        humanPresenter.addFamilyLink(childDoc, parentDoc);
    }

    public void addHuman() {
        String doc = getDocument();
        String name = getName();
        Gender gender = getGender();
        LocalDate date = getDate();
        humanPresenter.addHuman(doc,name,gender,date);
    }

    private LocalDate getDate() {
        System.out.println("Укажите дату рождения в формате ДД ММ ГГГГ: ");
        String str = scanner.nextLine();
        while (!isCorrectDate(str)) {
            System.out.println("Дата указана неверно");
            System.out.println("Укажите дату рождения в формате ДД ММ ГГГГ: ");
            str = scanner.nextLine();
        }
        String[] str_parts = str.split(" ");
        return LocalDate.of(Integer.parseInt(str_parts[2]), Integer.parseInt(str_parts[1]), Integer.parseInt(str_parts[0]));
    }

    private boolean isCorrectDate(String str) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
        dateFormat.setLenient(false);
        try {
            Date parsedDate = dateFormat.parse(str);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private Gender getGender() {
        genderMenu();
        String gender = scanner.nextLine();
        while (!isCorrectGender(gender)) {
            System.out.println("Введённое значение некорректно.");
            genderMenu();
            gender = scanner.nextLine();
        }
        if (gender.equals("1")) {
            return Gender.Male;
        }
        else {
            return Gender.Female;
        }
    }

    private void genderMenu() {
        System.out.println("Выберите пол:");
        System.out.println("1. Мужской");
        System.out.println("2. Женский");
    }

    private boolean isCorrectGender(String gender) {
        return gender.equals("1") || gender.equals("2");
    }

    private String getDocument() {
        System.out.print("Введите номер документа: ");
        return scanner.nextLine();
    }

    private String getName() {
        System.out.print("Введите имя: ");
        return scanner.nextLine();
    }

    public void finish() {
        humanPresenter.saveDataFile(filePath);
        work = false;
        System.out.println("Работа завершена.");
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void printTable(ArrayList<String> data) {
        List<List<String>> table = new ArrayList<>();

        int[] columnWidths = null;
        for (String row : data) {
            List<String> columns = Arrays.asList(row.split("//"));
            table.add(columns);
            if (columnWidths == null) {
                columnWidths = new int[columns.size()];
            }
            for (int i = 0; i < columns.size(); i++) {
                columnWidths[i] = Math.max(columnWidths[i], columns.get(i).length()) + 2;
            }
        }

        System.out.println(getTableString(table, columnWidths));

    }

    private String  getTableString(List<List<String>> table, int[] columnWidths) {
        StringBuilder out = new StringBuilder();
        int table_width=0;
        for (List<String> row : table) {
            out.append("|");
            for (int i = 0; i < row.size(); i++) {
                out.append(String.format("%" + columnWidths[i] + "s |", row.get(i)));
            }
            table_width=out.length()/ table.size();
            out.append("\n");
        }

        String header_line = "";
        for (int i = 0; i < table_width; i++) {
            header_line += "-";

        }
        out.insert(0, header_line + "\n");
        out.insert(table_width + header_line.length()+2, header_line + "\n");
        out.append(header_line).append("\n");
        return out.toString();
    }


    public void ShowTree() {
        humanPresenter.getTreeInfo();
    }
}
