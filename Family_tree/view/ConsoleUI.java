package Family_tree.view;

import java.time.LocalDate;
import java.util.Scanner;

import Family_tree.model.human.Gender;
import Family_tree.presenter.Presenter;

public class ConsoleUI implements View{

    private static final String INPUT_ERROR = "You've entered incorrect value";
    private Scanner scanner;
    private boolean work;
    private Presenter presenter;
    private Gender gender;
    private MainOptions options;

    
    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this); 
        work = true;
        options = new MainOptions(this);

    }

    @Override
    public void printAnswer(String answer){
        System.out.println(answer);
    }
    
    public void start(){
        hello();
        while (work){
            printOptions();            
            execute();
    
        }
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                options.execute(numCommand);
            }
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand <= options.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkTextForInt(String answer) {
        if (answer.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }     
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }

    private void printOptions() {
        System.out.println(options.options());
    }

    private void hello() {
        System.out.println("Hello! How can I help you? ");    
    }

    public void addHuman() {
        String name = setName();
        Gender gender = setGender();
        LocalDate dateOfBirth = setBirthDate();
        presenter.addHuman(name, gender, dateOfBirth); 
        getFamilyTreeMembers();
    }

    private LocalDate setBirthDate() {
        System.out.println("Please enter birth year: ");
        String yearString = scanner.nextLine();
        int year = Integer.parseInt(yearString);
        System.out.println("Please enter birth month in numbers format: "); 
        String monthString = scanner.nextLine();
        int month = Integer.parseInt(monthString);
        System.out.println("Please enter day of month: "); 
        String dayString = scanner.nextLine();
        int dayOfMonth = Integer.parseInt(dayString);
        LocalDate dateOfBirth = LocalDate.of(year, month, dayOfMonth);
        return dateOfBirth;
    }

    private Gender setGender() {
        System.out.println("Please choose gender: " + System.lineSeparator() +
        "1 - Male" + System.lineSeparator() +
        "2 - Female");
        String genderString = scanner.nextLine();
        boolean flag = true;
        while (flag) {
            switch (genderString) {
                case "1":
                    gender = Gender.Male;
                    flag = false;
                    break;
                case "2":
                    gender = Gender.Female;   
                    flag = false;
                    break;
                default:
                    inputError();
                    setGender();
                    flag = false;
                    break;
            }
        }
        return gender; 
    }

    private String setName() {
        System.out.println("Please enter name of the human to be added: ");
        String name = scanner.nextLine();
        return name;
    }

    public void getFamilyTreeMembers(){
        presenter.getFamilyTreeMembers();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void finish() {
        System.out.println("See you soon!");
        work = false;
    }

    public void setFather() {
        System.out.println("Please choose id of child");
        String childIdString = scanner.nextLine();
        int childId = Integer.parseInt(childIdString);
        System.out.println("Please choose id of father");
        String fatherIdString = scanner.nextLine();
        int fatherId = Integer.parseInt(fatherIdString);
        presenter.setFather(childId, fatherId); 
    }

    public void setMother() {
        System.out.println("Please choose id of child");
        String childIdString = scanner.nextLine();
        int childId = Integer.parseInt(childIdString);
        System.out.println("Please choose id of mother");
        String motherIdString = scanner.nextLine();
        int motherId = Integer.parseInt(motherIdString);
        presenter.setMother(childId, motherId); 
    }

    public void setSpouse() {
        System.out.println("Please choose id of husband");
        String husbandIdString = scanner.nextLine();
        int husbandId = Integer.parseInt(husbandIdString);
        System.out.println("Please choose id of wife");
        String wifeIdString = scanner.nextLine();
        int wifeId = Integer.parseInt(wifeIdString);
        presenter.setSpouse(husbandId, wifeId);     
    
    }
    public void setChild() {
        System.out.println("Please choose id of parent");
        String parentIdString = scanner.nextLine();
        int parentId = Integer.parseInt(parentIdString);
        System.out.println("Please choose id of child");
        String childIdString = scanner.nextLine();
        int childId = Integer.parseInt(childIdString);
        presenter.setChild(parentId, childId);     
    }
}
