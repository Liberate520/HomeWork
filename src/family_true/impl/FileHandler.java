/**
 * @author Ostrovskiy Dmitriy
 * @created 21.05.2024
 * class FileHandler
 * @version v1.0
 */

package family_true.impl;

import family_true.family_tree.FamilyTree;
import family_true.api.Externalizable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler implements Externalizable {

    public final static String OUTPUT_DIR_DEFAULT = "family_tree.txt";

    private String outputDir;

    public FileHandler() {
        this.outputDir = OUTPUT_DIR_DEFAULT;
    }

    public FileHandler(String outputDir) {
        this.outputDir = outputDir;
    }

    @Override
    public void writeAllExternal(List<FamilyTree> familyTreeList) {
        File file = new File(outputDir);
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(familyTreeList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("FamilyTree write to file. Length = " + file.length());
    }

    @Override
    public void updateExternal(FamilyTree familyTree) {
        List<FamilyTree> familyTreeList = readExternal();
        familyTreeList.add(familyTree);
        writeAllExternal(familyTreeList);
    }

    @Override
    public List<FamilyTree> readExternal() {
        List<FamilyTree> familyTreeList = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(outputDir))) {
            // Чтобы можно было добавлять новые FamilyTree нужно не присвоить вычитываемый объект, а именно добавлять к новому List
            familyTreeList.addAll((List<FamilyTree>) in.readObject());
        } catch (FileNotFoundException e) {
            System.out.println("File path '" + outputDir + "' NotFound!");
            e.printStackTrace();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("FamilyTree read from file.");
        return familyTreeList;
    }
}
