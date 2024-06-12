package FamilyTree.presenter;

import FamilyTree.model.builder.HumanBuilder;
import FamilyTree.model.builder.ItemBuilder;
import FamilyTree.model.element.ElementFamilyTree;
import FamilyTree.model.element.Human;
import FamilyTree.model.familyTree.FamilyTree;
import FamilyTree.model.familyTree.FileHandler;
import FamilyTree.model.element.Gender;
import FamilyTree.model.service.Service;
import FamilyTree.view.View;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Presenter<E extends ElementFamilyTree<E>> {
    private final View view;
    private final Service<E> service = new Service<>();
    private final HumanBuilder humanBuilder = new HumanBuilder();
    private final FileHandler<E> fileHandler = new FileHandler<>();

    public Presenter(View view){
        this.view = view;
    }

    public void createFamilyTree(String name){
        service.setName(name);
    }

    public void addElement(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Long father, Long mother, List<E> children, Long spouse){
        service.setItemBuilder(humanBuilder);
        E fatherE = searchById(father);
        E motherE = searchById(mother);
        E spouseE = searchById(spouse);
        service.addElement(name, gender, birthDate, deathDate, fatherE, motherE, children, spouseE);
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

    public List<E> searchByName(String name){
        return service.searchByName(name);
    }

    public E searchById(Long id){
        return service.searchById(id);
    }

    public void addParent(long longIdChild, long longIdParent){
        service.addParent(longIdChild, longIdParent);
        service.addChild(longIdChild, longIdParent);
    }

    public void addChild(long longIdChild, long longIdParent){
        service.addParent(longIdChild, longIdParent);
        service.addChild(longIdChild,longIdParent);
    }
}
