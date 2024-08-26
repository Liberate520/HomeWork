package presenter;

import model.family_tree.FamilyTreeItem;
import model.service.Service;
import view.View;

public class Presenter<E extends FamilyTreeItem> {
    private View view;
    private Service<E> service;

    public Presenter(View view) {
        this.view = view;
        service = new Service<>();
    }

    public void getFamilyTree() {
        String answer = service.printList(service.getFamilyTree());
        view.printAnswer(answer);
    }

    public void add(E item) {
        service.add(item);
        view.printAnswer("Запись добавлена: " + item);
    }

    public void findByName(String name) {
        String answer = service.printList(service.findByName(name));
        view.printAnswer(answer);
    }

    public E findById(int id) {
        return service.findById(id);
    }

    public void sortByName() {
        service.sortByName();
        String answer = service.printList(service.getFamilyTree());
        view.printAnswer(answer);
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        String answer = service.printList(service.getFamilyTree());
        view.printAnswer(answer);
    }

    public void sortByAge() {
        service.sortByAge();
        String answer = service.printList(service.getFamilyTree());
        view.printAnswer(answer);
    }

    public void updateItem(E item) {
        String answer = item.toString();
        view.printAnswer(answer);
    }

}
