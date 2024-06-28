package model.save_and_load;

import java.io.Serializable;

public interface Writable <E extends Serializable>{
    boolean save(E serializable, String file);
    E read(String file);
}
