
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;    

public class filehand implements Serializable {

    public void write (Object elem, String file) throws IOException, ClassNotFoundException{
           ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
           out.writeObject(elem);
   }

 
   public Family read(String path) throws IOException, ClassNotFoundException {
           ObjectInputStream intput = new ObjectInputStream(new FileInputStream(path));
           Family smt = (Family) intput.readObject();
           return smt;
   }
}