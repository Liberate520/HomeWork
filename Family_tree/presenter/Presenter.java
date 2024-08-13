package Family_tree.presenter;

import java.time.LocalDate;
    
import Family_tree.model.human.Gender;
import Family_tree.model.human.Human;
import Family_tree.model.service.Service;
import Family_tree.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public Human addHuman(String name, Gender gender, LocalDate dateOfBirth){
        return service.addToTree(name, gender,dateOfBirth);
    }

    public void getHuman(int id){
        String answer;
        if (isValid(id)) {
            answer = service.getById(id).toString();
        } else {
            answer = null;
            view.printAnswer(answer);
        }
    }

    private boolean isValid(int id){
        return (id >= 0 && id < service.size());
    }

    public void getFamilyTreeMembers(){
        String tree = service.getHumanListInfo();
        view.printAnswer(tree);
    }

    public void setFather(int childId, int fatherId){
        service.setFather(childId, fatherId);
        getFamilyTreeMembers();
    }

    public void setMother(int childId, int motherId){
        service.setMother(childId, motherId);
        getFamilyTreeMembers();
    }

    public void sortByName(){
        service.sortByName();
        getFamilyTreeMembers();
    }

    public void sortByAge(){
        service.sortByAge();
        getFamilyTreeMembers();
    }    

    public Human getById(int id) {
        return service.getById(id);
        
    }

    public void setSpouse(int husbandId, int wifeId) {
        service.setSpouse(husbandId, wifeId);
        getFamilyTreeMembers();
    }

    public void setChild(int parentId, int childId) {
        service.setChild(parentId, childId);
        getFamilyTreeMembers();
    }
}
