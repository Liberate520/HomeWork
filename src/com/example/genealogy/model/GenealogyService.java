package com.example.genealogy.model;
import java.util.List;

import com.example.genealogy.filehandler.FileHandlerInterface;
import com.example.genealogy.model.relationships.Relationship;


public class GenealogyService {
    
    private Person rootPerson;
    private GenealogyTree genealogyTree;
    private FileHandlerInterface fileHandler;

    public GenealogyService(FileHandlerInterface fileHandler) {
        this.genealogyTree = new GenealogyTree();
        this.fileHandler = fileHandler;
    }

    public void addPerson(String name) {
        genealogyTree.addPerson(name);
    }

    public void removePerson(String name) {
        genealogyTree.removePerson(name);
    }

    public void addRelationship(String person1, String person2, String relationship) {
        genealogyTree.addRelationship(person1, person2, relationship);
    }

    public void removeRelationship(String person1, String person2) {
        genealogyTree.removeRelationship(person1, person2);
    }

    public String printTree() { 
        if (rootPerson != null) {
        return printTree(rootPerson, "");
        }

        else {
            return "Дерево пустое";
        } 
    }

    private String printTree(Person person, String indent) {
        StringBuilder treeString = new StringBuilder();
        treeString.append(indent).append(person.getName()).append("\n");

        for (Relationship relationship : person.getRelationships()) {
            treeString.append(indent).append("  ").append(relationship.getPerson1().getName()).append(" (").append(relationship.getType()).append(")\n");
            treeString.append(printTree(relationship.getPerson1(), indent + "  "));
        }

        return treeString.toString();
    }

    public List<Person> getAllPeople() {
        return genealogyTree.getAllPeople();
    }

    public void saveTree(String filename) {
        fileHandler.saveTree(genealogyTree, filename);
    }

    public void loadTree(String filename) {
        genealogyTree = fileHandler.loadTree(filename);
    }
}
