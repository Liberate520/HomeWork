package View.Commands;

import model.Model;
import model.familyTree.Gender;
import java.time.LocalDate;
import View.View;

public class AddMember extends Command {

    public AddMember(Model model, View view) {
        super(model, view);
    }

    @Override
    public void execute() {
        String name = view.getNameInput();
        Gender gender = view.getGenderInput();
        LocalDate birthDate = view.getBirthDateInput();
        LocalDate deathDate = view.getDeathDateInput();
        model.addMember(name, gender, birthDate, deathDate);
        view.showMessage("Сделано!");
    }

    @Override
    public String getDescription() {
        return "Добавить члена семьи";
    }
}
