package presenter;

import model.Gender;
import service.FamilyTreeServiceImpl;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private FamilyTreeServiceImpl service;

    public Presenter(FamilyTreeServiceImpl service, View view) {
        this.service = service;
        this.view = view;
    }

    public void addHuman(String name, LocalDate dateOfBirth, Gender gender, String fatherName, LocalDate fatherBirthDate, String motherName, LocalDate motherBirthDate) {
        service.addHuman(name, dateOfBirth, gender, fatherName, fatherBirthDate, motherName, motherBirthDate);
        getHumanListInfo();
    }

    public void getHumanListInfo() {
        view.printAnswer(service.getHumanListInfo().toString());
    }

    public void sortByAge() {
        service.sortByBirthDate();
        getHumanListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }

    public void findMemberByName(String name) {
        view.printAnswer(service.findByNameStr(name));
    }

    public void findMembersByBirthYear(int year) {
        view.printAnswer(service.findByBirthYearStr(year));
    }

}
