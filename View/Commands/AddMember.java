package View.Commands;

import model.Model;
import model.familyTree.Gender;
import java.time.LocalDate;
import View.View;

public class AddMember implements Command {
    private Model model;
    private View view;

    public AddMember(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void execute() {
        String name = view.getNameInput();
        Gender gender = view.getGenderInput();
        LocalDate birthDate = view.getBirthDateInput();
        LocalDate deathDate = view.getDeathDateInput();
        model.addMember(name, gender, birthDate, deathDate);
        view.showMessage("Член семьи добавлен.");
    }

    @Override
    public String getDescription() {
        return "Добавить члена семьи";
    }
}
