package ru.gb.family.service;

import ru.gb.family.familyTree.FamilyTree;
import ru.gb.family.familyTree.GeneratFamalyTree;
import ru.gb.family.jobfiles.FileHandler;
import ru.gb.family.jobfiles.Writable;

import java.io.Serializable;

public class Service implements Serializable {

    public Service() {
    }

    public static void save(FamilyTree familyTree, String filePath) {
        Writable writable = new FileHandler();
        writable.save(familyTree, filePath);
    }

    public static FamilyTree read(String filePath) {
        Writable writable = new FileHandler();
        return (FamilyTree) writable.read(filePath);

    }

    public static boolean chekFile(String filePath) {
        Writable writable = new FileHandler();
        return writable.chekFile(filePath);
    }
    public static FamilyTree newFamilyTree(){
        GeneratFamalyTree generatFamalyTree = new GeneratFamalyTree();
        return generatFamalyTree.gen();
    }

    public static FamilyTree start (String path){
        if (Service.chekFile(path)) {
            return Service.read(path);
        } else {
            return Service.newFamilyTree();
        }
    }

}