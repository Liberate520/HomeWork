package presenter;

import java.time.LocalDate;
import java.util.List;

import model.family_tree.FamilyTreeService;
import model.human.Gender;
import model.human.Human;
import model.places.Place;
import view.View;

public class Presenter {
    private View view;
    private FamilyTreeService service;

    public Presenter(View view) {
        this.view = view;
        service = new FamilyTreeService();
    }

    public void addHuman(String firstName, String lastName, String patronymic,
            LocalDate birthDate, LocalDate deathDate, Gender gender,
            String nationality, Human father, Human mother, Human spouse,
            List<Human> children, Place place) {
        service.addHuman(firstName, lastName, patronymic, birthDate, deathDate, gender, nationality, father, mother,
                spouse, children, place);
        getFamilyTreeInfo();
    }

    public void addPlace(int homeNumber, String street, String region,
            String country, int postalCode, String locality) {
        service.addPlace(homeNumber, street, region, country, postalCode, locality);
        getFamilyTreeInfo();
    }

    public void sortByLastName() {
        service.sortByLastName();
        getFamilyTreeInfo();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getFamilyTreeInfo();
    }

    public void getFamilyTreeInfo() {
        String answer = service.getFamilyTreeInfo();
        view.printAnswer(answer);
    }
}
