package family_tree.model.services;

import family_tree.model.saving_data.FileHandler;

public class Service {

    public boolean saveDataFile(String filePath, Object data) {
        try {
            FileHandler fh = new FileHandler(filePath);
            fh.writeData(data);
            return true;
        }
        catch (RuntimeException e) {
            return false;
        }
    }

    public Object loadDataFile(String filePath) {
        try {
            FileHandler fh = new FileHandler(filePath);
            return fh.readData();
        }
        catch (Exception e) {
            return null;
        }
    }

}
