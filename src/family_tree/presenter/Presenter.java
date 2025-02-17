package family_tree.presenter;

import family_tree.model.FamilyTree;
import family_tree.view.View;
import family_tree.model.human.Gender;
import family_tree.model.service.Service;
import writer.Writer;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter  {
    private View view;
    private Service service;

    public Presenter(View view,Writer writer) {
        this.view = view;
        service = new Service (writer);
    }

    public void addHuman(String name, Gender gender, LocalDate date) {
        service.addHuman(name,gender,date);
//        TODO сделать какое-то отображение сделанных изменений для пользователя
        getHumanListInfo();

    }

    public void addParent(long humanId,long childId){
        service.addParent(humanId,childId);
      getHumanListInfo();
    }

    public void addMarriage(long human1, long human2){
        service.addMarriage(human1,human2);
        getHumanListInfo();
    }

    public void getHumanListInfo() {
       String answer =  service.familyTreeList();
       view.printAnswer(answer);
    }

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }

    public void saveToFile() throws IOException {
        service.saveToFile();
    }

    public FamilyTree readFromFile() throws IOException, ClassNotFoundException {
        return service.readFromFile();

    }
}
