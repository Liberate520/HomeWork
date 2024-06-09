package FamilyTree.presenter;

import FamilyTree.model.builder.HumanBuilder;
import FamilyTree.model.builder.ItemBuilder;
import FamilyTree.model.familyTree.ElementFamilyTree;
import FamilyTree.model.familyTree.FamilyTree;
import FamilyTree.model.familyTree.FileHandler;
import FamilyTree.model.human.Gender;
import FamilyTree.model.service.Service;
import FamilyTree.view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter<E extends ElementFamilyTree<E>> {
    private View view;
    private final Service<E> service = new Service<>();
    private final HumanBuilder<E> humanBuilder = new HumanBuilder<>();
    private final FileHandler<E> fileHandler = new FileHandler<>();

    public Presenter(View view){
        this.view = view;
    }

    public void createFamilyTree(String name){
        service.setName(name);
    }

    public void addElement(String name, Gender gender, LocalDate birthDate, LocalDate deathDate){
        service.setItemBuilder(humanBuilder);
        service.addElement(name, gender, birthDate, deathDate);
    }

    public void save() throws IOException {
        service.setWritable(fileHandler);
        service.save();
    }

    public void load(String name) throws IOException, ClassNotFoundException {
        service.setWritable(fileHandler);
        service.load(name);
    }

    public FamilyTree<E> viewFamilyTree(){
        return service.viewFamilyTree();
    }

    public void setWedding(long item1, long item2){
        service.setWadding(item1, item2);
    }

    public void sortedByName(){
        service.sortedByName();
    }

    public void sortedByAge(){
        service.sortedByAge();
    }
}
