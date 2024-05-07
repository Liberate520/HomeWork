package re.zip.famely_tree.view;

import static java.lang.Integer.parseInt;
import java.time.LocalDate;
import re.zip.famely_tree.model.human.Gender;
import re.zip.famely_tree.presenter.Presenter;

public class ConsoleUI implements View {

    private final InputOutput inputOutput;
    private final Presenter presenter;
    boolean workFlag;
    private final MainMenu mainMenu;

    public ConsoleUI(InputOutput inputOutput) {
        this.inputOutput = inputOutput;
        presenter = new Presenter(this);
        workFlag = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        while (workFlag) {
            inputOutput.println(mainMenu.getMenu());
            String strYourChoice = inputOutput.readLine();
            int choice = parseInt(strYourChoice);
            mainMenu.execute(choice);
        }
    }

    public void finish() {
        inputOutput.println("Работа закончена. До новых встреч");
        workFlag = false;
    }

    @Override
    public void printAnswer(String text) {
        inputOutput.println(text);
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void sortByFirstName() {
        presenter.sortByFirstName();
    }

    public void sortByFamelyName() {
        presenter.sortByFamelyName();
    }

    public void getFamelyListInfo() {
        presenter.getFamelyListInfo();
    }

    public void addHumanToFamelyTree() {
        inputOutput.println("Введите имя: ");
        String firstName = inputOutput.readLine();

        inputOutput.println("Введите фамилию: ");
        String lastName = inputOutput.readLine();

        inputOutput.println("Введите дату рождения(в формате: XXXX-YY-ZZ, где XXXX - год, YY - месяц, ZZ - день): ");
        String strLocalDate = inputOutput.readLine();
        LocalDate localDate = LocalDate.parse(strLocalDate);

        inputOutput.println("Ввендите пол(Male/Female): ");
        String strGender = inputOutput.readLine();
        Gender gender = Gender.valueOf(strGender);

        presenter.addHumanToFamelyTree(firstName, lastName, localDate, gender);
    }


    public void saveToFile(String filePath) {
        presenter.saveToFile(filePath);
    }

    public void loadFromFile(String filePath) {
        presenter.loadFromFile(filePath);
    }

    public void setWeddding() {
        inputOutput.println("Введите ID номер первого из супругов: ");
        String strPartner1ID = inputOutput.readLine();
        Integer partner1ID = Integer.valueOf(strPartner1ID);

        inputOutput.println("Введите ID номер вторго из супругов: ");
        String strPartner2ID = inputOutput.readLine();
        Integer partner2ID = Integer.valueOf(strPartner2ID);

        inputOutput.println("Менялась ли фамилия супругов(0 - нет, 1 - взята фамилия первого супруга, 2 - взята фамилия второго супруга: ");
        String strNewFamelyName = inputOutput.readLine();
        Integer getFamelyName = parseInt(strNewFamelyName);

        presenter.setWeddding(partner1ID, partner2ID, getFamelyName);
    }
    

    public void setChildParentRelationship() {
        inputOutput.println("Введите ID номер родителя(любого, в случае, если они замжем): ");
        String strParentID = inputOutput.readLine();
        Integer parentID = parseInt(strParentID);

        inputOutput.println("Введите ID ребенка: ");
        String strChildID = inputOutput.readLine();
        Integer childID = parseInt(strChildID);

        presenter.setChildParentRelationship(parentID, childID);
    }

}