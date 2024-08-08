package ru.gb.familytree.FamilyTree;

import java.io.*;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> relatives;

    public void setRelative(Human human) {
        this.relatives.add(human);
    }

    public List<Human> getParentsForHuman(Human human) {
        return relatives.get(relatives.indexOf(human)).getParents();
    }

    public List<Human> getChildrenForHuman(Human human) {
        return relatives.get(relatives.indexOf(human)).getChildren();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("FamilyTree{\n");
        for (Human relative : this.relatives) {
            stringBuilder.append(relative.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public void save(String filePath) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
            out.writeObject(this);
            out.close();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
