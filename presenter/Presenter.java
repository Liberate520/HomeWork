package presenter;

import java.time.LocalDate;
import java.util.List;

import model.family_tree.FamilyTreeServiceInterface;
import model.human.Gender;
import model.human.Human;
import model.places.Place;
import view.ConsoleUI;
import view.MainMenu;
import view.View;
import view.commands.*;

// Применяем DIP: Presenter теперь зависит от интерфейса FamilyTreeServiceInterface.
// Применяем DIP: Presenter зависит от ObjectWriter и ObjectReader.

public class Presenter {
    private View view;
    private FamilyTreeServiceInterface service;
    private MainMenu menu;

    public Presenter(FamilyTreeServiceInterface service) {
        this.service = service;
        this.menu = new MainMenu();
    }

    public void setView(View view) {
        this.view = view;
        registerCommands();
    }

    private void registerCommands() {
        menu.addCommand(new AddHuman(this));
        menu.addCommand(new AddPlace(this));
        menu.addCommand(new AddBirthPlace(this));
        menu.addCommand(new SortByLastName(this));
        menu.addCommand(new SortByBirthDate(this));
        menu.addCommand(new GetFamilyTreeInfo(this));
        menu.addCommand(new SaveFamilyTree(this));
        menu.addCommand(new LoadFamilyTree(this));
        menu.addCommand(new Finish(this, view));
    }

    public void executeCommand(int commandNumber) {
        menu.execute(commandNumber);
    }

    public void saveFamilyTree() {
        service.saveTree();
        view.printAnswer("Дерево сохранено.");
    }

    public void loadFamilyTree() {
        service.loadTree();
        view.printAnswer("Дерево загружено.");
    }

    public void addHuman(String firstName, String lastName, String patronymic, LocalDate birthDate, LocalDate deathDate,
            Gender gender, String nationality, Human father, Human mother, Human spouse, List<Human> children,
            Place birthPlace) {
        service.addHuman(firstName, lastName, patronymic, birthDate, deathDate, gender, nationality, father, mother,
                spouse, children, birthPlace);
        getFamilyTreeInfo();
    }

    public void addPlace(int homeNumber, String street, String region, String country, int postalCode,
            String locality) {
        service.addPlace(homeNumber, street, region, country, postalCode, locality);
        getFamilyTreeInfo();
    }

    public void addBirthPlace(long humanID, long placeID) {
        service.addBirthPlace(humanID, placeID);
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
        String info = service.getFamilyTreeInfo();
        view.printAnswer(info);
    }

    public String getMenu() {
        return menu.menu();
    }

    public View getView() {
        return this.view;
    }
}
