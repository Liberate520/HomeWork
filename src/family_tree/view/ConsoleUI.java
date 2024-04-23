package family_tree.view;

import family_tree.model.Human.Gender;
import family_tree.model.Human.Human;
import family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI(){
        this.scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        mainMenu = new MainMenu(this);

    }

    public void start(){
        hello();
        while(work){
            System.out.println(mainMenu.getMenu());
            String strChoice = scanner.nextLine();
            //проверяем choice на валидность
            int choice = Integer.parseInt(strChoice);
            mainMenu.execute(choice);
        }
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    private void hello() {
        System.out.println("Выберите действие");
    }

    public void finish(){
        System.out.println("До новых встреч!");
        work = false;
    }

    public void sortByName(){
        presenter.sortByName();
    }

    public void sortByBirthday(){
        presenter.sortByBirthday();
    }

    public void getHumanListInfo(){
        presenter.getHumanListInfo();
    }
    public Gender stringToGender(String str) {
        if (str.equals("null")){
            return null;
        } else{
        return Gender.valueOf(str.trim().toUpperCase());
        }
    }

    public List<Human> convertNamesToHumans(List<String> names) {
        List<Human> humans = new ArrayList<>();

        for (String name : names) {

            Human human = new Human(name);
            humans.add(human);
        }
        return humans;
    }

    public void addHuman() {
        System.out.println("Укажите имя");
        String name = scanner.nextLine();
        System.out.println("Укажите дату рождения в формате ГГГГ-ММ-ДД");
        String strDateDob = scanner.nextLine();
        LocalDate dob = LocalDate.parse(strDateDob);
        System.out.println("Укажите дату смерти в формате ГГГГ-ММ-ДД или null");
        String strDateDod = scanner.nextLine();
        LocalDate dod = null;
        if (strDateDod.equals("null")) {
            dod = null;
        } else {
            dod = LocalDate.parse(strDateDod);
        }

        System.out.println("Укажите пол в формате male - female");
        String strGender = scanner.nextLine();
        Gender gender = Gender.valueOf(strGender.trim().toUpperCase());
        System.out.println("Укажите имена детей через запятую");
        String strChildren = scanner.nextLine();
        List<String> myList = new ArrayList<String>(Arrays.asList(strChildren.split(",")));
        List<Human> child = convertNamesToHumans(myList);
        System.out.println("Укажите имя мамы");
        String strMother = scanner.nextLine();
        Human mother = new Human(strMother);
        System.out.println("Укажите имя отца");
        String strFather = scanner.nextLine();
        Human father = new Human(strFather);

        presenter.addHuman(name, dob, dod, gender, child, mother, father);
    }


}
