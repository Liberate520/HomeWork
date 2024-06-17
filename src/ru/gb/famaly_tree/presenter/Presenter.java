package ru.gb.famaly_tree.presenter;

import ru.gb.famaly_tree.model.ft.Famaly_tree;
import ru.gb.famaly_tree.model.human.Gender;
import ru.gb.famaly_tree.model.human.Human;
import ru.gb.famaly_tree.model.service.Service;
import ru.gb.famaly_tree.view.View;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public Human createHuman(String name, Gender gender, LocalDate birthDate, LocalDate deathDate){
        return service.createHuman(name,gender,birthDate,deathDate);
    }

    public Human createHuman(String name,Gender gender, LocalDate birthDate, LocalDate deathDate,Human mother, Human father, List<Human> children){
        return service.createHuman(name,gender,birthDate,deathDate, mother, father, children);
    }

    public boolean isFirstHumanInFamalyTree(){
        return service.isFirstHumanInFamalyTreeM();
    }

    public boolean addPersonInFamalyTree(Human h1){
        return service.addPersonInFamalyTree(h1);
    }

    public void addPersonInFamalyTree(Human h1, Human h2){
        service.addPersonInFamalyTree(h1, h2);
    }

    public String outputHumanInfo(Human human){
        return service.outputHumanInfo(human);

    }

    public void addCoupl(Human h1, Human h2){
        service.addCoupl(h1,h2);
    }

    public String outputFamalyTree(Human human){
        return service.outputFamalyTree(human);
    }

    public String outputFamalyTree(){
        return service.outputFamalyTree();
    }

    public String outputHumanList(){
        return service.outputHumanList();
    }

    public String outputHumanListSortByAge(boolean b){
        return service.outputHumanListSortByAge(b);
    }

    public String outputHumanListSortByChildrenCount(boolean b){
        return service.outputHumanListSortByChildrenCount(b);
    }

    public String outputHumanListSortByName(boolean b){
        return service.outputHumanListSortByName(b);
    }

    public Human searchByName(String name){
        return service.searchByName(name);
    }

    public void save() throws IOException {
       service.save();
    }

    public void download() throws IOException, ClassNotFoundException {
        service.download();
    }
}
