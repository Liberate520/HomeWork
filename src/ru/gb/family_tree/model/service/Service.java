package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.dataHandler.FileHandler;
import ru.gb.family_tree.model.dataHandler.Writeble;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.member.Gender;
import ru.gb.family_tree.model.member.Member;
import ru.gb.family_tree.model.member.member_comparator.MemberComparatorByAge;
import ru.gb.family_tree.model.member.member_comparator.MemberComparatorByName;
import ru.gb.family_tree.model.member.member_comparator.MemberComparatorByNumberOfChild;
import ru.gb.family_tree.model.tree.FamilyTree;

import java.io.IOException;
import java.time.LocalDate;

public class Service {
    private FamilyTree<Member> ft;
    private Writeble writeble;

    public Service(Writeble writeble) {
        ft = new FamilyTree<>();
        this.writeble = writeble;
    }

    public void addMember(String name, Member mother, Member father, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        Member member = new Human(name, mother, father, birthDate, deathDate, gender);
        ft.addMember(member);
    }
    public Member findMember(String name) {
        return ft.findMember(name);
    }
    public String getFullTree() {
        return ft.getFullTree();
    }
    public void sortByName(){
        ft.sortByName();
    }
    public void sortByAge(){
        ft.sortByAge();
    }
    public void sortByChild(){
        ft.sortByChild();
    }

    public void writeData(String filename) throws IOException {
        writeble.writeData(this.ft, filename);
    }
    public void readData(String filename) throws IOException, ClassNotFoundException {
        this.ft = (FamilyTree<Member>) writeble.readData(filename);
    }


}
