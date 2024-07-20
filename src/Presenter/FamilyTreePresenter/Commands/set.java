package Presenter.FamilyTreePresenter.Commands;

import Formating.MyDate;
import Model.Checks;
import Model.Creatures.Gender.Gender;
import Model.Interface.Creature;
import Model.Interface.FamilyTreeInterface;
import Presenter.BaseClasses.Command;
import Presenter.Interface.Performing;
import View.Interface.FamilyTreeView;

public class set extends Command implements Performing {
    private final FamilyTreeInterface familyTree;
    private final FamilyTreeView view;

    public set(FamilyTreeView view, FamilyTreeInterface<?> familyTree){
        super("set", "Изменить данные о существе");

        this.familyTree = familyTree;
        this.view = view;
    }

    private void changeName(Creature creature){
        this.view.println(String.format("\tCurrent value - %s, new value: ", creature.getName()));
        String newName = this.view.nextLine();

        if (newName.equals("null")) newName = null;

        creature.setName(newName);

        this.view.printSignedMessage("Result", "Successful");
    }

    private void changeSurname(Creature creature){
        this.view.println(String.format("\tCurrent value - %s, new value: ", creature.getSurname()));

        String newSurname = this.view.nextLine();

        if (newSurname.equals("null")) newSurname = null;

        creature.setSurname(newSurname);

        this.view.printSignedMessage("Result", "Successful");
    }

    private void changeGender(Creature creature){
        this.view.println(String.format("\tCurrent value - %s, new value: ", creature.getGender()));
        String gender = this.view.nextLine();

        if (gender.equals("null")){
             creature.setGender(null);

        } else{
            if (gender.equalsIgnoreCase(Gender.male.toString())){
                creature.setGender(Gender.male);

                this.view.printSignedMessage("Result", "Successful");

            } else if (gender.equalsIgnoreCase(Gender.female.toString())){
                creature.setGender(Gender.female);

                this.view.printSignedMessage("Result", "Successful");

            } else this.view.printSignedMessage("ERROR", "Unknown gender");
        }
    }

    private void changeSpouse(Creature creature){
        this.view.println("\tID new spouse: ");

        String spouseID = this.view.nextLine();

        if (spouseID.equals("null"))
            creature.setSpouse(null);

        else{
            Integer intSpouseID = Checks.parseInt(spouseID);

            if (intSpouseID == null){
                this.view.printSignedMessage("ERROR", "Uncorrected character");

            } else {
                creature.setSpouse(this.familyTree.getCreature(intSpouseID));

                this.view.printSignedMessage("Result", "Successful");
            }
        }
    }

    private void changeMather(Creature creature){
        this.view.println("\tID new mather: ");

        String matherID = this.view.nextLine();

        if (matherID.equals("null"))
            creature.setMather(null);

        else{
            Integer intMatherID = Checks.parseInt(matherID);

            if (intMatherID == null){
                this.view.printSignedMessage("ERROR", "Uncorrected character");

            } else {
                Creature mather = this.familyTree.getCreature(intMatherID);

                if (mather == null){
                    this.view.printSignedMessage("ERROR", "Creature was not found");

                } else{
                   creature.setMather(mather);

                   this.view.printSignedMessage("Result", "Successful");
                }
            }
        }
    }

    private void changeFather(Creature creature){
        this.view.println("\tID new father: ");

        String fatherID = this.view.nextLine();

        if (fatherID.equals("null"))
            creature.setFather(null);

        else{
            Integer intFatherID = Checks.parseInt(fatherID);

            if (intFatherID == null){
                this.view.printSignedMessage("ERROR", "Uncorrected character");

            } else {
                Creature father = this.familyTree.getCreature(intFatherID);

                if (father == null){
                    this.view.printSignedMessage("ERROR", "Creature was not found");

                } else {
                    creature.setFather(father);

                    this.view.printSignedMessage("Result", "Successful");
                }
            }
        }
    }

    private void changeDataOfBirth(Creature creature){
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
            this.view.printSignedMessage("ERROR", "Uncorrected character");

        } else {
            MyDate date = new MyDate(year, month, day);

            if (date.getYear() == null || date.getMonth() == null || date.getDay() == null){
                this.view.printSignedMessage("ERROR", "Uncorrected data");

            } else {
                creature.setDateOfBirth(date);

                this.view.printSignedMessage("Result", "Successful");
            }
        }
    }

    private void changeDataOfDeath(Creature creature){
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
            this.view.printSignedMessage("ERROR", "Uncorrected character");

        } else {
            MyDate date = new MyDate(year, month, day);

            if (date.getYear() == null || date.getMonth() == null || date.getDay() == null){
                this.view.printSignedMessage("ERROR", "Uncorrected data");

            } else {
                creature.setDataOfDeath(date);

                this.view.printSignedMessage("Result", "Successful");
            }
        }
    }

    private void addChildren(Creature creature){
        this.view.println("\tID new kid: ");

        String kidID = this.view.nextLine();

        Integer intKidID = Checks.parseInt(kidID);

        if (intKidID == null) this.view.printSignedMessage("ERROR", "Uncorrected character");

        else {
            creature.addChildren(this.familyTree.getCreature(intKidID));

            this.view.printSignedMessage("Result", "Successful");
        }
    }

    @Override
    public void execute() {
        this.view.println("\tID: ");

        Integer ID = Checks.parseInt(this.view.nextLine());

        if (ID == null)
            this.view.printSignedMessage("ERROR", "Uncorrected character");

        else{
            Creature creature = this.familyTree.getCreature(ID);

            if (creature == null){
                this.view.printSignedMessage("ERROR", "The creature was not found");

            } else {
                this.view.println("\tField name: ");
                String field = this.view.nextLine();

                if (field.equalsIgnoreCase("name")) changeName(creature);

                else if (field.equalsIgnoreCase("surname")) changeSurname(creature);

                else if (field.equalsIgnoreCase("gender")) changeGender(creature);

                else if (field.equalsIgnoreCase("spouse")) changeSpouse(creature);

                else if (field.equalsIgnoreCase("mather")) changeMather(creature);

                else if (field.equalsIgnoreCase("father")) changeFather(creature);

                else if (field.equalsIgnoreCase("data of birth")) changeDataOfBirth(creature);

                else if (field.equalsIgnoreCase("data of death")) changeDataOfDeath(creature);

                else if (field.equalsIgnoreCase("children")) addChildren(creature);

                else this.view.printMessage("Unknown field");
            }
        }
    }
}