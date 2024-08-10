import java.io.*;

public class FileHandler implements Writer{
    private String filePath;
    public boolean save(Serializable serializable){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
          objectOutputStream.writeObject(serializable);
          return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    public Object read(){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            objectInputStream.readObject();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void setPath(String filePath) {
        this.filePath = filePath;
    }
}
