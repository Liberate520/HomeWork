import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteToFile implements WriteInterface {
    private String path;

    public WriteToFile(String path) {
        this.path = path;
    }

    public void write(FamilyTree ft) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(path));
            objectOutputStream.writeObject(ft);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
