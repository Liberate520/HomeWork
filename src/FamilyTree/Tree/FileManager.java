package family_tree.FamilyTree.Tree;

import java.io.*;


public class FileManager implements Serialise {
    String name;

    public FileManager(String name) {
        this.name = name;
    }


    //TODO на тесте (интерфейс Serializable). есть вопросы по правильности. Доработано
    @Override
    public void write(FamilyTree tree) throws IOException {

        try (ObjectOutputStream export = new ObjectOutputStream(new FileOutputStream(this.name))) {
            export.writeObject(tree);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    //TODO на тесте (интерфейс Serializable). есть вопросы по правильности. Доработано
    @Override
    public FamilyTree read() throws IOException {
        FamilyTree tree = new FamilyTree();
        try (ObjectInputStream importData = new ObjectInputStream(new FileInputStream(this.name))) {
            tree = (FamilyTree) importData.readObject();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return tree;
    }


}
