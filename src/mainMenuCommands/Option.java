package DZ1.mainMenuCommands;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Option {
    void execute() throws FileNotFoundException, ClassNotFoundException, IOException;

    String discription();
}
