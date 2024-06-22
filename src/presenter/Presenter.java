package presenter;

import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.writer.FileHandler;
import model.service.Service;
import model.writer.Writable;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;
//    private Writable fileHandler;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
//        this.fileHandler = new FileHandler();
    }

    public void loadTree(String filePath) {
        service.loadTree(filePath);
        view.printAnswer("Дерево загружено.");
    }

    public void saveTree(String filePath) {
        service.saveTree(filePath);
        view.printAnswer("Дерево сохранено.");
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate) {
        service.addHuman(name, gender, birthDate);
        view.printAnswer("Человек добавлен: " + name);
    }


    public void setWedding(long id1, long id2) {
        if (service.setWedding(id1, id2)) {
            view.printAnswer("Брак установлен.");
        } else {
            view.printAnswer("Ошибка при установлении брака.");
        }
    }

    public void setDivorce(long id1, long id2) {
        if (service.setDivorce(id1, id2)) {
            view.printAnswer("Развод оформлен.");
        } else {
            view.printAnswer("Ошибка при оформлении развода.");
        }
    }

    public void getTreeInfo() {
        view.printAnswer(service.getTree().toString());
    }

    public void sortByBirthDate() {
        service.getTree().sortByBirthDate();
        view.printAnswer("Дерево отсортировано по дате рождения.");
    }

    public void sortByName() {
        service.getTree().sortByName();
        view.printAnswer("Дерево отсортировано по имени.");
    }



    public void addChild(long parentId, String name, Gender gender, LocalDate birthDate) {
        boolean added = service.addChild(parentId, name, gender, birthDate);
        if (added) {
            view.printAnswer("Ребёнок успешно добавлен.");
        } else {
            view.printAnswer("Не удалось добавить ребёнка.");
        }
    }


}
