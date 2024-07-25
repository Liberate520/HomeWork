package ru.gb.family_tree.writer;

import ru.gb.family_tree.FamilyTree;
import ru.gb.family_tree.Human;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHendler implements Writer{

   // private List<Human> humans;
   private FamilyTree tree;

    public FileHendler(FamilyTree tree) {
        this.tree = tree;
    }

    public void serializationToFile() {

            ObjectOutputStream objectOutputStream = null;
            try {
                objectOutputStream = new ObjectOutputStream(
                        new FileOutputStream("human.out"));

            for (Human human : tree.listHuman) {
                objectOutputStream.writeObject(human);
            }
            objectOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }

    public List<Human> restoringFromFile() {

      List<Human> restorHumans =new ArrayList<>();
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(
                    new FileInputStream("human.out"));

        for (int i = 0; i < tree.listHuman.size(); i++) {
            Human human = (Human) objectInputStream.readObject();
            restorHumans.add(human);
        }
        objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return restorHumans;
        }






}
