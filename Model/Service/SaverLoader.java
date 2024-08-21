package homeWork.Model.Service;

import java.io.IOException;

import homeWork.Model.Human.Human;
import homeWork.Model.Tree.FamilyTree;
import homeWork.Model.Writer.FileHandler;
import homeWork.Model.Writer.Writer;

public class SaverLoader<T> {
    private final Writer writer;

    public SaverLoader(Writer writer) {
        this.writer = writer;
    }

    public void saveToFile(FamilyTree tree, String fileName) throws IOException {
        try {
            writer.writeToFile(tree, fileName);
        } catch (IOException e) {

            throw new IOException("Error saving data to file: " + e.getMessage(), e);
        }
    }

    public FamilyTree loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try {
            return writer.readFromFile(fileName);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error loading data from file: " + e.getMessage(), e);
        }
    }
}
