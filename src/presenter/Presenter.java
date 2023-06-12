package presenter;

import model.Service;
import view.View;

import java.io.IOException;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
    }

    public void loadData() throws IOException, ClassNotFoundException {
        service.loadData();
    }

    public void saveData() throws IOException {
        service.saveData();
    }

    public void printSortByName() {
        service.printSortByName();
    }

    public void printSortByDOB() {
        service.printSortByDOB();
    }

}
