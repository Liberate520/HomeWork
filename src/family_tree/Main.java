package family_tree;

import family_tree.model.FamilyTreeModel;
import family_tree.model.Human;
import family_tree.presenter.FamilyTreePresenter;

public class Main {
    public static void main(String[] args) {
        FamilyTreeModel model = new FamilyTreeModel();
        FamilyTreePresenter presenter = new FamilyTreePresenter(model);

        Human mikhail = new Human("Михаил", "Мужской", "17-03-1953", "07-03-2018");
        Human lyudmila = new Human("Людмила", "Женский", "28-02-1955", null);
        Human vladimir = new Human("Владимир", "Мужской", "07-11-1977", null);
        Human ivan = new Human("Иван", "Мужской", "26-07-1945", "10-08-2016");
        Human nina = new Human("Нина", "Женский", "28-01-1950", null);
        Human natalya = new Human("Наталья", "Женский", "25-07-1978", null);
        Human andrey = new Human("Андрей", "Мужской", "13-09-1998", null);

        model.addBeing(mikhail);
        model.addBeing(lyudmila);
        model.addBeing(vladimir);
        model.addBeing(ivan);
        model.addBeing(nina);
        model.addBeing(natalya);
        model.addBeing(andrey);

        mikhail.addChild(vladimir);
        lyudmila.addChild(vladimir);
        nina.addChild(natalya);
        ivan.addChild(natalya);
        vladimir.addChild(andrey);
        natalya.addChild(andrey);

        presenter.onInit();
    }
}
