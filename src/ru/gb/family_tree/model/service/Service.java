package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.member.Gender;
import ru.gb.family_tree.model.member.Member;
import ru.gb.family_tree.model.member.member_comparator.MemberComparatorByAge;
import ru.gb.family_tree.model.member.member_comparator.MemberComparatorByName;
import ru.gb.family_tree.model.member.member_comparator.MemberComparatorByNumberOfChild;
import ru.gb.family_tree.model.tree.FamilyTree;

import java.time.LocalDate;

public class Service {
    private int idMember;
    private FamilyTree<Member> ft;

    public Service() {
        ft = new FamilyTree<>();
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
}
