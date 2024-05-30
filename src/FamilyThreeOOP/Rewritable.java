package FamilyThreeOOP;

import java.io.Serializable;

public interface Rewritable {
    boolean saveToFile(Serializable serializable, String fileName);
    Object loadFromFile(String fileName);
}