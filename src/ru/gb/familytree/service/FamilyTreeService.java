package ru.gb.familytree.service;

import ru.gb.familytree.model.HumanInfo;
import ru.gb.familytree.repository.FamilyTreeRepository;

import java.util.List;

public class FamilyTreeService {
    private FamilyTreeRepository repository;

    public FamilyTreeService(FamilyTreeRepository repository) {
        this.repository = repository;
    }

    public void addMember(HumanInfo member) {
        repository.addMember(member);
    }

    public void sortByName() {
        List<HumanInfo> members = repository.getMembers();
        members.sort((h1, h2) -> h1.getName().compareToIgnoreCase(h2.getName()));
    }

    public void sortByDob() {
        List<HumanInfo> members = repository.getMembers();
        members.sort((h1, h2) -> h1.getDob().compareTo(h2.getDob()));
    }

    public List<HumanInfo> getMembers() {
        return repository.getMembers();
    }

    public HumanInfo findPersonByName(String name) {
        return repository.findPersonByName(name);
    }
}