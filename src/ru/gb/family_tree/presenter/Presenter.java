package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.dataHandler.Readable;
import ru.gb.family_tree.model.dataHandler.Writeble;
import ru.gb.family_tree.model.member.Gender;
import ru.gb.family_tree.model.member.Member;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.view.View;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Writeble writeble, Readable readable){
        this.view = view;
        service = new Service(writeble, readable);
    }

    public void addMember(String name, Member mother, Member father, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        service.addMember(name, mother, father, birthDate, deathDate, gender);
    }
    public String getFullTree() {
        return service.getFullTree();
    }
    public void sortByName(){
        service.sortByName();
    }
    public void sortByAge(){
        service.sortByAge();
    }
    public void sortByChild(){
        service.sortByChild();
    }
    public Member findMember(String name) {
        return service.findMember(name);
    }
    public List<Member> findAllInfoByName(String name) {return service.findAllInfoByName(name);}
    public void writeData(String filename) throws IOException {
        service.writeData(filename);
    }
    public void readData(String filename) throws IOException, ClassNotFoundException {
        service.readData(filename);
    }
}
