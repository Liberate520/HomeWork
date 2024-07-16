package presenter;

import model.builder.Gender;
import model.builder.Human;
import model.service.Service;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }

    public Human createHuman(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        return service.createHuman(name, gender, birthDate, deathDate, father, mother);
    }

    public Human createHuman(String name, Gender gender, LocalDate birthDate) {
        return service.createHuman(name, gender, birthDate);
    }

    public Human createHuman(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        return service.createHuman(name, gender, birthDate, father, mother);
    }

    public void setWedding(Human human1, Human human2) {
        service.setWedding(human1, human2);
    }

    public void addChild(Human parent, Human child) {
        service.addChild(parent, child);
    }

    public String getFamilyTreeInfo() {
        return service.getFamilyTreeInfo(); // Передаем запрос в сервис
    }

    public void saveFamilyTree() {
        service.saveFamilyTree();
    }
}
