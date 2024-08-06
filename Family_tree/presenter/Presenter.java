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
            answer = "Something went wrong";
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
        String answer;
        StringBuilder sb = new StringBuilder();
        if (isValid(childId) && isValid(fatherId)) {
            service.setFather(childId, fatherId);
            sb.append(service.getById(childId).getName());
            sb.append("'s father has been added");
            answer = sb.toString();
        } else answer = "Something went wrong";
        view.printAnswer(answer);
        System.out.println();
        getFamilyTreeMembers();
        setChild(fatherId, childId);
    }

    public void setMother(int childId, int motherId){
        String answer;
        StringBuilder sb = new StringBuilder();
        if (isValid(childId) && isValid(motherId)) {
            service.setFather(childId, motherId);
            sb.append(service.getById(childId).getName());
            sb.append("'s mother has been added");
            answer = sb.toString();
        } else answer = "Something went wrong";
        view.printAnswer(answer);
        System.out.println();
        getFamilyTreeMembers();
        setChild(motherId, childId);
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
        String answer;
        StringBuilder sb = new StringBuilder();
        if (isValid(husbandId) && isValid(wifeId)) {
            service.setSpouse(husbandId, wifeId);
            sb.append("Husband-wife relationship has been set between ");
            sb.append(service.getById(husbandId).getName());
            sb.append(" and ");
            sb.append(service.getById(wifeId).getName());
            answer = sb.toString();
        } else {
            answer = "Something went wrong";
        }
        view.printAnswer(answer);
        System.out.println();
        getFamilyTreeMembers();
    }

    public void setChild(int parentId, int childId) {
        String answer;
        StringBuilder sb = new StringBuilder();
        if (isValid(parentId) && isValid(childId)) {
            service.setChild(parentId, childId);
            sb.append("Parent-child relationship has been set between ");
            sb.append(service.getById(parentId).getName());
            sb.append(" and ");
            sb.append(service.getById(childId).getName());
            answer = sb.toString();
        } else {
            answer = "Something went wrong";
        }
        view.printAnswer(answer);
        System.out.println();
        getFamilyTreeMembers();
    }

    public Object read() {
        return service.read();
        
    }

    public void saveTheTree() {
        service.save("src/Family_tree/writer/result.txt");    
    }
}
