package family_tree.view;

import family_tree.presenter.Presenter;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }
    private void hello(){
        System.out.println("Hello!");
    }

    public void finish() {
        System.out.println("Bye Bye!");
        work = false;
    }

    public void sortByName() { presenter.sortByName();
    }

    public void sortByAge() { presenter.sortByAge();
    }

    public void humansInfo() { presenter.humansInfo();
    }

    public void addHuman() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();

        System.out.println("Укажите фамилию: ");
        String surname = scanner.nextLine();

        System.out.println("Укажите дату рождения (гггг-мм-дд)");
        String dobString = scanner.nextLine();
        LocalDate dob = LocalDate.parse(dobString);

        System.out.println("Укажите дату смерти (гггг-мм-дд) (или оставьте пустым)");
        String dodString = scanner.nextLine();
        LocalDate dod = dodString.isEmpty() ? null : LocalDate.parse(dodString);

        System.out.println("Укажите пол (male/female)");
        String genderString = scanner.nextLine();


//        System.out.println("Введите имя и фамилию отца (если известно, иначе оставьте пустым)");
//        String fatherName = scanner.nextLine();
//        // todo
//
//        System.out.println("Введите имя и фамилию отца матери (если известно, иначе оставьте пустым)");
//        String motherName = scanner.nextLine();
//        // todo
//
//        System.out.println("Укажите количество детей (если есть, иначе введите 0)");
//        String childrenCountString = scanner.nextLine();
//        int childrenCount = Integer.parseInt(childrenCountString);
//        List<Human> children = new ArrayList<>();
//        for (int i = 0; i < childrenCount; i++) {
//            System.out.println("Введите имя ребенка " + (i + 1));
//            String childName = scanner.nextLine();
//            children.add(new Human(childName));
//        }

        presenter.addHuman(name, surname, dob, dod, gender, null, null, null);
    }

    private void execute(){
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

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);

}
