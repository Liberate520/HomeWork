package familytree.presenter;

import familytree.model.human.Human;
import familytree.model.human.Gender;
import familytree.model.family_tree.FamilyTree;
import familytree.model.util.FileHandler;
import familytree.view.IFamilyTreeView;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class FamilyTreePresenter implements IFamilyTreePresenter {
    private FamilyTree<Human> familyTree;
    private IFamilyTreeView view;
    private FileHandler fileHandler;

    public FamilyTreePresenter(IFamilyTreeView view) {
        this.view = view;
        this.familyTree = new FamilyTree<>();
        this.fileHandler = new FileHandler();
    }
    @SuppressWarnings("unchecked")
    @Override
    public void loadFamilyTree() {
       // String filePath = view.getFilePath();
        //fileHandler.setPath(filePath);
        familyTree = (FamilyTree<Human>) fileHandler.readFromFile();
        if (familyTree != null) {
            view.displayMessage("Family tree loaded from file");
        } else {
            view.displayMessage("Error loading family tree");
        }
    }

    @Override
    public void saveFamilyTree() {
        //String filePath = view.getFilePath();
        //.setPath(filePath);
        fileHandler.writeToFile(familyTree);
        view.displayMessage("Family tree saved to file");
    }

    @Override
    public void displayFamilyTree() {
        view.displayFamilyTree(familyTree.toString());
    }

    @Override
    public void sortByName() {
        familyTree.sortByName();
        view.displaySortedTreeByName(familyTree.toString());
    }

    @Override
    public void sortByAge() {
        familyTree.sortByAge();
        view.displaySortedTreeByAge(familyTree.toString());
    }

    @Override
    public void createFamilyTree() {
        Human grandparent = new Human("Prohor", Gender.Male, LocalDate.of(1949, 5, 21));
        Human parent1 = new Human("Alice", Gender.Female, LocalDate.of(1973, 8, 15));
        Human parent2 = new Human("Ignat", Gender.Male, LocalDate.of(1975, 1, 22));
        Human child1 = new Human("Alla", Gender.Female, LocalDate.of(2003, 11, 10));
        Human child2 = new Human("Diana", Gender.Female, LocalDate.of(2005, 6, 4));

        grandparent.addChild(parent1);
        grandparent.addChild(parent2);
        parent1.addChild(child1);
        parent2.addChild(child2);

        parent1.addParent(grandparent);
        parent2.addParent(grandparent);
        child1.addParent(parent1);
        child2.addParent(parent2);

        familyTree.addHuman(grandparent);
        familyTree.addHuman(parent1);
        familyTree.addHuman(parent2);
        familyTree.addHuman(child1);
        familyTree.addHuman(child2);

        view.displayMessage("Create family tree");
    }

    @Override
    public void addHumanToTree(String name, String gender, String birthDateStr, String deathDateStr) {
        try {            
            LocalDate birthDate = LocalDate.parse(birthDateStr);
            LocalDate deathDate; 
            if (deathDateStr.isEmpty()){
                deathDate = null; 
            } else {
                deathDate = LocalDate.parse(deathDateStr);
            }
                       
            Gender gen = Gender.valueOf(gender);  
                                  
            Human newHuman = new Human(name, gen, birthDate, deathDate);
            familyTree.addHuman(newHuman);
            view.displayMessage("New human added to the family tree");
        } catch (DateTimeParseException | IllegalArgumentException e) {
            view.displayMessage("Error: Invalid data format");
        }
    }
}
