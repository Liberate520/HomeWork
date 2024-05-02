package presenter;

import model.human.Gender;
import view.View;

import java.io.IOException;
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

    public void addParent(int numMemberId, int numParentId) {
        if (numMemberId < service.getFamilySize() && numParentId < service.getFamilySize()) {
            service.addParent(numMemberId, numParentId);
            view.printAnswer("Члену семьи успешно добавлен родитель");
            getMembersInfo();
        } else {
            view.printAnswer("Такого id не существует");
        }
    }

    public void getMembersInfo() {
        String info = service.getMembersInfo();
        view.printAnswer(info);
    }

    public void getChildrenInfo(int memberId) {
        if (memberId < service.getFamilySize()) {
            String info = service.getChildrenInfo(memberId);
            view.printAnswer(info);
        }
    }

    public void sortByAge() {
        service.sortByAge();
        getMembersInfo();
    }

    public void sortByName() {
        service.sortByName();
        getMembersInfo();
    }

    public void saveTree() throws IOException {
        service.saveTree();
        view.printAnswer("Проект сохранён");
    }

    public void downloadTree() throws IOException, ClassNotFoundException {
        service.downloadTree();
        view.printAnswer("Проект загружен");
        getMembersInfo();
    }

}
