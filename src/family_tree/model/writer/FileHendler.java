package family_tree.model.writer;

import family_tree.model.family_tree.FamilyTree;

import java.io.*;

public  class FileHendler implements Writer {
    private String filePath = "src/family_tree/family_tree/person.out";

    @Override
    public void save(FamilyTree serializable) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serializable);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Object read() {
        try (ObjectInputStream objectInputStreamt = new ObjectInputStream(new FileInputStream(filePath))){
            Object object = objectInputStreamt.readObject();
            return object;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void setPath(String path) {
        this.filePath = filePath;
    }
}
