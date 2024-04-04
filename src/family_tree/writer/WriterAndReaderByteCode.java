package family_tree.writer;

import family_tree.person.Human;
import family_tree.tree.FamilyTree;

import java.io.*;

public class WriterAndReaderByteCode implements Serializable {
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private String fileNameForTree;
    private String fileNameForPeople; // I don't understand how this interface (Serializable) is
                                     // writing different classes, so I created separate variable for Human class.

    public WriterAndReaderByteCode() {
    }



    public void writerInitialization(String fileName) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(fileName));
        this.out = out;
        this.fileNameForTree = fileName;
    }

    public boolean writeTreeAsByteCode(FamilyTree outputObject) {
        try{
            this.out.writeObject(outputObject);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean writeHumanAsByteCode(Human outputObject) {
        try{
            this.out.writeObject(outputObject);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void readerInitialization(String fileName) throws IOException {
        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(fileName));
        this.in = in;
        this.fileNameForTree = fileName; //? needed
    }

    public FamilyTree readTreeFromByteCodeFile() throws ClassNotFoundException {
        try{
            return (FamilyTree) this.in.readObject();
        } catch (IOException e) {
            return null;
        }
    }
    public Human readHumanFromByteCodeFile() throws ClassNotFoundException {
        try{
            return (Human) this.in.readObject();
        } catch (IOException e) {
            return null;
        }
    }


    public String getFileName() {
        return fileNameForTree;
    }
}
