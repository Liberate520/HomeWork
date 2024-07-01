package seminar2.presenter;

import seminar2.View.commands.View;
import seminar2.model.Human.Gender;
import seminar2.model.Human.Human;
import seminar2.model.Service.FileHandler;
import seminar2.model.Service.Service;
import seminar2.model.Service.Writable;
import seminar2.model.Tree.FamilyTree;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

//*    private FamilyTree tree;
//*    private Human human;

    public Presenter(View view) {
        this.view = view;
        service = new Service();

//*        tree = new FamilyTree();
//*        human = new Human(null, null, null, null, null, null,null, null);
    }

    public void addRelative(String name, String surname, Gender valueOf, LocalDate dateOfBirth) {
       // Human human = new Human(name, surname, valueOf, dateOfBirth);
        service.addRelative(name, surname, valueOf, dateOfBirth);
        service.getInfo();;
//        service.add(human);
//        tree.getInfo();
    }

    public void getByNameSurname(String name, String surname) {
        service.getByNameSurname(name, surname);
    }


    public void getByOneFamily(String surname) {
        service.getByOneFamily(surname);
    }

    public void getTreeInfo() {
        String answer = service.getInfo();
        view.printAnswer(answer);
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sorBySurname() {
        service.sorBySurname();
    }

    public void sortByAge() {
        service.sortByAge();
    }

    String path = "src/seminar2/output.txt";
    public void save() throws IOException {
        Writable file = new FileHandler();
        file.save((Serializable) service, path);
    }

    public Service load(String path) throws IOException, ClassNotFoundException {
        Writable file = new FileHandler();
        return (Service) file.load(path);
    }
}
