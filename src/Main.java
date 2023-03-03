import Model.FamilyFree;
import Model.Human;
import presenter.Presenter;
import Viev.Console;
import Viev.View;

public class Main {
    public static void main(String[] args) {
        FamilyFree<Human> familyFree = new FamilyFree<>();
        familyFree.addFamilyFree(new Human("�����", "���.", 35));
        familyFree.addFamilyFree(new Human("�����", "���.", 27));
        familyFree.addFamilyFree(new Human("�����", "���.", 7,
                familyFree.getByName("����"), familyFree.getByName("�����")));
        familyFree.addFamilyFree(new Human("����", "���.", 5,
                familyFree.getByName("����"), familyFree.getByName("�����")));

        familyFree.addFamilyFree(new Human("��������", "���.", 333));
        familyFree.getByName("�����").addChild(familyFree.getByName("�����"));

        View view = new Console();
        new Presenter(view, familyFree);
        view.start();
    }
}