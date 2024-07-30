package ru.gb.familytree.repository;

import ru.gb.familytree.model.HumanInfo;
import ru.gb.familytree.writer.FileHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileFamilyTreeRepository implements FamilyTreeRepository {
    private List<HumanInfo> familyTree;
    private FileHandler fileHandler;
    private String filePath;

    public FileFamilyTreeRepository(String filePath) {
        this.familyTree = new ArrayList<>();
        this.fileHandler = new FileHandler();
        this.filePath = filePath;
        loadFromFile();
    }

    @Override
    public void addMember(HumanInfo member) {
        familyTree.add(member);
        saveToFile();
    }

    @Override
    public List<HumanInfo> getMembers() {
        return new ArrayList<>(familyTree);
    }

    @Override
    public HumanInfo findPersonByName(String name) {
        return familyTree.stream()
                .filter(member -> member.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    private void saveToFile() {
        try {
            fileHandler.save(familyTree, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        try {
            this.familyTree = fileHandler.load(filePath);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}