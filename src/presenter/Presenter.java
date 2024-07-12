package presenter;

import model.family.HumanService;
import model.family.human.Gender;
import view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private HumanService humanService;
//    String answer;
    String errMessage;
    public Presenter(View view) {
        this.view = view;
        this.humanService = new HumanService();
//        answer = "";
        errMessage = "Что-то пошло не так";
    }


    public void addHuman(String name, LocalDate birthDate, Gender gender){
        String answer;
        if (humanService.addHumanToTree(name, birthDate, gender)){
            answer = "человек добавлен";
        } else answer = errMessage;
        view.answer(answer);
    }

    public void printTree(){
        String answer;
        answer = humanService.printTreeInfo();
        view.answer(answer);

    }

    public void getHuman(int id){
        String answer;
        if (isValid(id)) {
            answer = humanService.getById(id).toString();

        } else answer = errMessage;
        view.answer(answer);
    }

    public void setParent(int childId, int parentId){
        String answer;
        StringBuilder sb = new StringBuilder();
        if (childId >=0
                && childId < humanService.size()
                && parentId >= 0
                && parentId < humanService.size()
                && humanService.setParent(childId, parentId)){
            sb.append("Родитель для ");
            sb.append(humanService.getById(childId));
            sb.append(" добавлен!");
            answer = sb.toString();
        } else answer = errMessage;
        view.answer(answer);
    }

    public void getChildren(int id){
        String answer;
        if (isValid(id)){
            answer = humanService.getChildren(id).toString();
        } else answer = errMessage;
        view.answer(answer);
    }

    public void getSiblings(int id){
        String answer;
        if (isValid(id))
            answer = humanService.getSiblings(id).toString();
        else answer = errMessage;
        view.answer(answer);
    }

    public void getAncestors(int id, int gen){
        String answer;
        if (isValid(id))
            answer = humanService.getAncestors(id, gen).toString();
        else answer = errMessage;
        view.answer(answer);
    }

    public void getDescendants(int id, int gen){
        String answer;
        if (isValid(id))
            answer = humanService.getDescendants(id, gen).toString();
        else answer = errMessage;
        view.answer(answer);
    }

    public void sortByName(){
        String answer;
        humanService.sortByName();
        answer = humanService.printTreeInfo();
        view.answer(answer);
    }

    public void sortByAge(){
        String answer;
        humanService.sortByAge();
        answer = humanService.printTreeInfo();
        view.answer(answer);
    }

    private boolean isValid(int id){
        return (id >= 0 && id < humanService.size());
    }
}
