package view;
import model.family_tree.instances.Gender;
import model.family_tree.instances.Human;
import presenter.Presenter;
import java.io.IOException;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;
    Calendar calendar = Calendar.getInstance();

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    public void addHuman(){
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();

        System.out.println("Выберите пол человека (1 - мужской, 2 - женский: ");
        boolean flag = true;
        String genderString = "";
        while (flag){
            genderString = scanner.nextLine();
            if(genderString.equals("1") || genderString.equals("2")){
                flag = false;
            }else {
                System.out.println("Пол введен не верно, попробуйте заново:\n");
            }
        }

        Gender gender;

        if(genderString.equals("1")){
            gender = Gender.Male;
        }else {gender = Gender.Female;}

        Date date = getDate(); //Получение даты
        Human human = new Human(name, date, gender);

        presenter.addToTree(human);
        showTree();
    }

    public void showTree(){
        presenter.showTree();
    }

    public void readFromFile() throws IOException, ClassNotFoundException {
        presenter.readFromFile();
        showTree();
    }

    public void saveToFile() throws IOException {
        presenter.saveToFile();
        showTree();
    }

    public void sortByAge(){
        presenter.sortByAge();
        showTree();
    }

    public void sortByBirthDate(){
        presenter.sortByBirthDate();
        showTree();
    }

    public void sortByDeathDate(){
        presenter.sortByDeathDate();
        showTree();
    }

    public void setFather(){
        System.out.println("Выберети индекс человека к которому нужно установить отца:");
        showTree();
        boolean flag = true;

        Human human = getHumanByIndex("Выберети человека для назначения ему отца");
        Human father;

        while (flag){
            father = getHumanByIndex("Выберети отца");
            if(human.equals(father)){
                System.out.println("Отец и ега ребенок не могут быть одним и тем же человеком");
            } else if (father.getGender() == Gender.Female) {
                System.out.println("Отец не может быть женщиной, попробуйте заново\n");
            } else if (father.getAge() < human.getAge()) {
                System.out.println("Отец не может быть младше своего ребенка, попробуйте заново\n");
            } else {
                flag = false;
                presenter.setFather(human, father);
            }
        }
    }

    public void setMother(){
        System.out.println("Выберети индекс человека к которому нужно установить мать:");
        showTree();
        boolean flag = true;

        Human human = getHumanByIndex("Выберети человека для назначения ему матери");
        Human mother;

        while (flag){
            mother = getHumanByIndex("Выберети мать");
            if(human.equals(mother)){
                System.out.println("Мать и ега ребенок не могут быть одним и тем же человеком");
            } else if (mother.getGender() == Gender.Male) {
                System.out.println("Мать не может быть мужчиной, попробуйте заново\n");
            } else if (mother.getAge() < human.getAge()) {
                System.out.println("Мать не может быть младше своего ребенка, попробуйте заново\n");
            } else {
                flag = false;
                presenter.setMother(human, mother);
            }
        }
    }

    /**
     * Парсинг в Integer c консоли
     * @param value значение
     * @return значение в формате Integer
     */
    public Integer parseIntOrNull(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Human getHumanByIndex(String message){
        Human human = null;
        boolean flag = true;
        int indexInt;
        String index;

        System.out.println(message + "\n");

        while (flag){
            index = scanner.nextLine();
            if(checkTextForInt(index)){
                indexInt = parseIntOrNull(index);
                if(indexInt > 0 && indexInt <= presenter.getNumbeInfamily()){
                    human = presenter.getFamilyMember(indexInt - 1);
                    flag = false;
                }else {
                    System.out.println("Введен не верный индекс, попробуйте заново:\n");
                }
            }else {
                System.out.println("Было введено не число, попробуйте заново:\n");
            }
        }
        return human;
    }

    /**
     * Получение даты
     * @return дата
     */
    public Date getDate(){
        Integer dayInt = 0; //день
        Integer monthInt = 0; //месяц
        Integer yearInt = 0; //год

        System.out.println("Введите дату рождения:\n");

        boolean flag = true;
        while (flag){
            System.out.println("Введите год: ");
            String year = scanner.nextLine();
            yearInt = parseIntOrNull(year);
            if(yearInt == null || yearInt < 0 || yearInt > calendar.get(Calendar.YEAR)){
                System.out.println("Год введен не в верном формате");
            }else { flag = false; }
        }

        flag = true;
        while (flag){
            System.out.println("Введите месяц: ");
            String month = scanner.nextLine();
            monthInt = parseIntOrNull(month);
            if(monthInt == null || monthInt < 1 || monthInt > 12){
                System.out.println("Месяц введен не в верном формате");
            }else { flag = false; }
        }

        flag = true;
        int maxDaysInMonth = YearMonth.of(yearInt, monthInt).lengthOfMonth();
        while (flag){
            System.out.println("Введите число: ");
            String day = scanner.nextLine();
            dayInt = parseIntOrNull(day);
            if(dayInt == null || dayInt < 1 || dayInt > maxDaysInMonth){
                System.out.println("День введен не в верном формате");
            }else { flag = false; }
        }

        return new Date(yearInt - 1900, monthInt - 1, dayInt);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    private void hello(){
        System.out.println("Доброго времени суток!");
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void execute() throws IOException, ClassNotFoundException {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }
}
