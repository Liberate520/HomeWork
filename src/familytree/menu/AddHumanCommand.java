package familytree.menu;

import familytree.presenter.FamilyTreePresenter;

public class AddHumanCommand implements Command {
    private FamilyTreePresenter presenter;
    private String name;
    private String gender;
    private String birthDate;
    private String deathDate;

    public AddHumanCommand(FamilyTreePresenter presenter, String name, String gender, String birthDate, String deathDate) {
        this.presenter = presenter;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    @Override
    public void execute() {
        presenter.addHumanToTree(name, gender, birthDate, deathDate);
    }
}