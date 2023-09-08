package presenter;

import model.familyTree.service.Service;
// import view.ConsoleUI;
import view.View;



public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, String lastname,  int age) {
        service.addHuman(name, lastname, age);
        getHumanListInfo();
        // String answer = service.addHuman(name, lastname, age);
        // view.printAnswer(answer);
    }

    public void getHumanListInfo() {
        String info = service.getHumanInfo();
        view.printAnswer(info);
        // String answer = service.getHumanInfo();
        // view.printAnswer(answer);
    }

    public void sortByAge() {
        service.sortByAge();
        getHumanListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }
}
