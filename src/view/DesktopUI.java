package view;

import model.builder.Gender;
import model.builder.Human;
import presenter.FamilyTreePresenter;

import java.time.LocalDate;

public class DesktopUI implements View {
    private FamilyTreePresenter presenter;

    public DesktopUI() {
        presenter = new FamilyTreePresenter(new ConsoleFamilyTreeView());
    }

    @Override
    public Human createHuman(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        return presenter.createHuman(name, gender, birthDate, deathDate, father, mother);
    }

    @Override
    public Human createHuman(String name, Gender gender, LocalDate birthDate) {
        return presenter.createHuman(name, gender, birthDate);
    }

    @Override
    public Human createHuman(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        return presenter.createHuman(name, gender, birthDate, father, mother);
    }

    public void setWedding(Human human1, Human human2) {
        presenter.setWedding(human1, human2);
    }

    public void addChild(Human parent, Human child) {
        presenter.addChild(parent, child);
    }

    public String showFamilyTreeInfo() {
        return presenter.getFamilyTreeInfo();
    }

    public void saveFamilyTree() {
        presenter.saveFamilyTree();
    }
}
