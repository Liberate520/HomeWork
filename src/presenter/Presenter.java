package presenter;

import model.human.Gender;
import view.View;
import java.time.LocalDate;
import model.service.Service;

public class Presenter {

    private final View view;
    private final Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addMember(String name, LocalDate dob, Gender gender) {
        service.addMember(name, dob, gender);
        view.printAnswer("Член семьи успешно добавлен");
        getMembersInfo();
    }

    public void getMembersInfo() {
        String info = service.getMembersInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        getMembersInfo();
    }

    public void sortByName() {
        service.sortByName();
        getMembersInfo();
    }

}
