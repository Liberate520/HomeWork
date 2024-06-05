package Model.WorkingWithFile;
import Model.TypeOfRelationship.TypeOfRelationship;

import java.io.*;
public class DataLoad implements FileProcessing {
    @Override
    public TypeOfRelationship read(String fileAddress) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileAddress));
        TypeOfRelationship tree =  (TypeOfRelationship)in.readObject();
        in.close();
        return tree;
    }
    @Override
    public void save(TypeOfRelationship tree, String fileAddress) throws IOException {
        ObjectOutputStream out  = new ObjectOutputStream( new FileOutputStream(fileAddress));
        out.writeObject(tree);
        out.close();
    }
}