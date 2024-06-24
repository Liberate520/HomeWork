package Family_tree.presenter;

import ru.gb.Family_tree.model.family_tree.Family_tree;
import ru.gb.Family_tree.model.human.Human;
import ru.gb.Family_tree.view.View;

public class Presenter {
    private View view;
    private Family_tree tree;

    public Presenter(View view) {
        this.view = view;
        tree = new Family_tree();
    }


    public void add(String name, String gender, String birthDate) {
        tree.add(new Human(name, gender, birthDate));
        getInfo();
    }

    public void getInfo() {
        String answer = tree.getInfo();
        view.printAnswer(answer);
    }

    public void sortName() {
        tree.sortName();
        getInfo();
    }

    public void sortBirthDate() {
        tree.sortBirthDate();
        getInfo();
    }
}
