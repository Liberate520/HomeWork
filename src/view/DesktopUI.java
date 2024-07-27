package view;

import model.builder.Gender;
import model.builder.Human;
import presenter.Presenter;

import java.io.IOException;
import java.time.LocalDate;

public class DesktopUI {
    private Presenter presenter;

    public DesktopUI() {
        presenter = new Presenter();
    }

    public void start() throws IOException {
        Human human1 = createHuman("Николай", Gender.MALE, LocalDate.of(1963, 12, 18));
        Human human2 = createHuman("Зинаида", Gender.FEMALE, LocalDate.of(1966, 11, 14));
        Human human3 = createHuman("Маша", Gender.FEMALE, LocalDate.of(1985, 11, 18));
        setWedding(human1, human2);
        addChild(human1, human3);
    }

    public Human createHuman(String name, Gender gender, LocalDate birthDate) throws IOException {
        Human human = presenter.createHuman(name, gender, birthDate);
        presenter.addHumanToFamilyTree(human);
        showMessage("Создан новый человек: " + human.getName() + "\n");
        return human;
    }


    public void setWedding(Human human1, Human human2) {
        presenter.setWedding(human1, human2);
    }

    public void addChild(Human parent, Human child) {
        presenter.addChild(parent, child);
    }

    public void addParent(Human parent, Human child) {
        presenter.addParent(parent, child);
    }

    public void showMessage(String message){
        System.out.println(message);
    }
}
