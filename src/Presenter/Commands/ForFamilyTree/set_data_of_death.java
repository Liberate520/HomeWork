package Presenter.Commands.ForFamilyTree;

import Model.Checks;
import Model.Creature.Entity;
import Model.FamilyTree.Tree;
import Model.Formating.MyDate;
import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import View.View;

public class set_data_of_death extends Command implements Performing {
    private final Tree familyTree;
    private final View view;

    public set_data_of_death(View view, Tree familyTree){
        super("set data of death", "Изменить дату смерти");

        this.view = view;
        this.familyTree = familyTree;
    }

    private void set(Entity entity){
        this.view.println("\tYear: ");
        String userYear = this.view.nextLine();

        this.view.println("\tMonth: ");
        String userMonth = this.view.nextLine();

        this.view.println("\tDay: ");
        String userDay = this.view.nextLine();

        Integer year = Checks.parseInt(userYear);
        Integer month = Checks.parseInt(userMonth);
        Integer day = Checks.parseInt(userDay);

        if (year == null || month == null || day == null){
            this.view.printMessage("ERROR", "Uncorrected character");

        } else {
            MyDate date = new MyDate(year, month, day);

            if (date.getYear() == null || date.getMonth() == null || date.getDay() == null){
                this.view.printMessage("ERROR", "Uncorrected data");

            } else {
                entity.setDataOfDeath(date);

                this.view.printMessage("Result", "Successful");
            }
        }
    }

    @Override
    public void execute() {
        this.view.println("\thuman ID: ");

        Integer ID = Checks.parseInt(this.view.nextLine());

        if (ID == null)
            this.view.printMessage("ERROR", "Uncorrected character");

        else {
            Entity entity = this.familyTree.getCreature(ID);

            if (entity == null) {
                this.view.printMessage("ERROR", "The creature was not found");

            } else{
                set(entity);
            }
        }
    }
}
