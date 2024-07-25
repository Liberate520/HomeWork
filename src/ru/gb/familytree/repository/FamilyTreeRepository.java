package ru.gb.familytree.repository;

import ru.gb.familytree.model.HumanInfo;

import java.util.List;

public interface FamilyTreeRepository {
    void addMember(HumanInfo member);
    List<HumanInfo> getMembers();
    HumanInfo findPersonByName(String name);
}