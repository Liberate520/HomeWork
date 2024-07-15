package presenter;

import model.family.Alivable;
import model.family.Service;
import model.family.human.HumanService;
import model.family.human.Gender;
import model.rw.Writer;
import view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter<U extends Alivable<U>> {
    private View view;
    private Service<U> humanService;
//    String answer;
    String errMessage;
    public Presenter(View view, Service<U> service) {
        // Можно менять вью и менять вид животного, указывая конкретный сервис.
        // Сохранение через сеттер, так как это, мне кажется, более гибко, чтобы
        // одно и то же дерево можно было сохранять в разные места
        this.view = view;
        this.humanService = service;

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
        humanService.sortByName();
        printTree();
    }

    public void sortByAge(){
        humanService.sortByAge();
        printTree();
    }

    public void save(){
        String answer = "";
        try {
            humanService.save();
            answer = String.format("Файл сохранен в %s", humanService.getPath());
        } catch (IOException e){
            e.printStackTrace();
            answer = errMessage;
        } finally {
            view.answer(answer);
        }

    }

    public void load(String path){
        try {
            humanService.load(path);
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException c){
            c.printStackTrace();
        }
    }

    private boolean isValid(int id){
        return (id >= 0 && id < humanService.size());
    }

}
