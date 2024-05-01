package presenter;

import model.service.FamilyTreeService;
import model.service.HumanFamilyTree;
import model.writer.FileHandler;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private final FamilyTreeService service;

    public Presenter(View view) {
        service = new HumanFamilyTree(new FileHandler());
    }

    public void addObject(String name, LocalDate dob, String viewGender) {
        service.addObject(name, dob, viewGender);
    }

    public String getTree() {
        return service.getTreeInfo();
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public void sortByName() {
        service.sortByName();
    }

    public boolean saveTree() {
        return service.save();
    }

    public void readTree() {
        service.read();
    }

    public boolean addParentByID(int parentID, int childID) {
        return service.addParentByID(parentID, childID);
    }

}
