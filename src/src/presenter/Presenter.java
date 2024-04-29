package src.presenter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import src.model.Gender;
import src.model.Model;
import src.view.View;

public class Presenter {
    @SuppressWarnings("unused")
    private View view;
    private Model model;

    public Presenter(View view) {
        this.view = view;
        this.model = new Model();

    }

    public boolean addPerson(String name, Gender gender, LocalDate dateB) {
        return model.addPerson(name, gender, dateB);

    }

    public boolean sortByName() {
        return model.sortByName();

    }

    public boolean sortByAge() {
        return model.sortByAge();

    }

    public boolean kinship(String txt) {
        return model.kinship(txt);
    }

    public void prinrtListInfo() {
        model.printList();
    }

    public boolean fileUpload(File file) throws FileNotFoundException, ClassNotFoundException, IOException{
        model.fileUpload(file);
        return true;
    }

    public boolean savingToFile(String file) throws FileNotFoundException, IOException{
        model.savingToFile(file);
        return true;
    }


}
