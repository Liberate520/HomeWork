package family_tree.view.actions;

import family_tree.presenter.Presenter;
import java.time.LocalDate;
import java.util.Scanner;

public class AddHumanAction implements MenuActions {
    Scanner scanner = new Scanner(System.in);
    private int id;

    public void execute(Presenter presenter) {
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
        String genderString = scanner.nextLine().toLowerCase();
        if (genderString.equals("male")) {
            presenter.addHuman(name, surname, dob, dod, presenter.fromStringToGender("male"));
        } else if (genderString.equals("female")) {
            presenter.addHuman(name, surname, dob, dod, presenter.fromStringToGender("female"));
        } else { System.out.println("Не соответствует male/female"); }


    }
}
