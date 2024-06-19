package model.tree;

import java.io.Serializable;

public interface  Writable {
    boolean save(Serializable serializable, String fileName);
    Object read(String fileName);

    /*
    public String writeTree(model.tree.FamilyTree model.tree, String FileName) throws IOException {
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FileName));
            objectOutputStream.writeObject((model.tree));
            objectOutputStream.close();
        } catch (Exception e){
            return e.toString();
        }
        return "ок";
    }
    public model.tree.FamilyTree readTree(String FileName) throws IOException {
        model.tree.FamilyTree model.tree = new model.tree.FamilyTree();
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FileName));
            model.tree = (model.tree.FamilyTree)  objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e){
            return null;
        }
        return model.tree;
    }
    */
}


