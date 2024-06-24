package View;

import Model.Human.Gender;
import Model.Human.Human;

import java.io.IOException;
import java.time.LocalDate;

public interface IView {

    static void printAnswer(String text){
        System.out.println(text);
    }

    void start() throws IOException, ClassNotFoundException;

    void finish();

    static void hello() {
        System.out.println("Добрый день!");
    }

    static void bye() {
        System.out.println("До свидания");
    }

    void execute() throws IOException, ClassNotFoundException;


    void printMenu();




    void addCreature();


    String setName();

    Gender setGender();

    LocalDate setBirthDate();

    LocalDate setDeathDate(LocalDate birthDate);







//    private Gender choiceGender() {
//        System.out.println("Введите пол существа: Мужской/Женский");
//        String genderChoice = scanner.nextLine();
//        while (!CheckMethods.checkChoiceGender(genderChoice)) {
//            System.out.println("Введите пол существа: Мужской/Женский");
//            genderChoice = scanner.nextLine();
//        }
//        Gender gender = null;
//        if (genderChoice.equalsIgnoreCase("Мужской")) {
//            gender = Gender.Male;
//        } else if (genderChoice.equalsIgnoreCase("Женский")) {
//            gender = Gender.Female;
//        }
//        return gender;
//    }










    void printFamilyTree();

    void getInfo();

    void sortByAge();

    void sortByName();

    void sortByCountChildren();

    boolean checkId(String id);

    Human getCreatureById(String id);

    void addMother();

    void addFather();

    void removeMother();

    void removeFather();

    void addChild();

    void removeChild();

    void setSpouse();

    void setDivorce();

    void writeObjectToFile() throws IOException;

    void recoverObjectFromFile() throws IOException, ClassNotFoundException;
}
