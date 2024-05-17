package Family_Tree.presenter;
import Family_Tree.model.FamilyTree.Service;
import Family_Tree.model.Human.Gender;
import Family_Tree.view.View;

public class Presenter{
    private final View view;
    private final Service service;




    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void sortByAge(){
        service.sortByAge();
        getInf();
    }
    public void sortByName(){
        service.sortByName();
        getInf();
    }

    public void addHuman(String name, Integer age, Gender gender){
 //   Human human = new Human(name, age, gender);
    service.addHuman(name, age, gender);
}

    public void getInf() {
        String answer = service.getInf();
        view.printAnswer(answer);
    }
}
