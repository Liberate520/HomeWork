package presenter;

import form.familyTree.FamilyTree;
import form.forming.Create;
import form.forming.Gender;
import form.forming.Human;
import form.save.FileHandler;
import view.View;

import java.time.LocalDate;
import java.util.ArrayList;

public class Presenter {
    private View view;
    private FamilyTree familyTree;
    private Create lastHuman;

    public Presenter(View view) {
        this.view = view;
        familyTree = new FamilyTree<Human>(new ArrayList<>());
    }

    public void loadingTree(String filePatch) {
        familyTree = (FamilyTree) new FileHandler().read(filePatch);
        view.printAnswer("Заружено дерево\n" + familyTree);
    }

    public void savingTree(String filePatch) {
        new FileHandler().save(familyTree, filePatch);
        view.printAnswer("Сохраненно дерево\n в" + filePatch + "\n" + familyTree);
    }

    public void addHuman(String name, Gender gender, String birthDate, String deathDate) {
        lastHuman = new Human(name, gender, birthDate, null);
        familyTree.addCreature(lastHuman);
        view.printAnswer(lastHuman.toString());
    }

    public boolean findHuman(String name) {
        lastHuman = familyTree.findFirsIn(name);
        if (lastHuman != null) {
            view.printAnswer(lastHuman.toString());
            return true;
        } else {
            return  false;
        }
    }

    public String shortPrintTree() {
        return familyTree.toString();
    }

    public String longPrintTree() {
        return familyTree.findFirsAll("").toString();
    }

    public int getSizeTree() {
        return  familyTree.getSize();
    }

    public void setParents(int indexMother, int indexFather) {
        lastHuman.setParents((Human) familyTree.getFamilyList().get(indexMother), (Human) familyTree.getFamilyList().get(indexFather));
        view.printAnswer(lastHuman.toString());
    }

    public void getAge() {
        view.printAnswer(Integer.toString(lastHuman.getAge()));
    }

    public void getParents() {
        view.printAnswer(lastHuman.getParents().toString());
    }

    public void getChildren() {
        view.printAnswer(lastHuman.getChildren().toString());
    }

    public void getGrandparents() {
        view.printAnswer(lastHuman.getGrandparents().toString());
    }

    public void getGrandsons() {
        view.printAnswer(lastHuman.getGrandsons().toString());
    }

    public void sortName() {
        familyTree.sortByName();
    }

    public void sortAge() {
        familyTree.sortByAge();
    }

    public void sortNumberChildren() {
        familyTree.sortByNumberChildren();
    }

}
