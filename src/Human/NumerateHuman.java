package Human;

import java.io.Serializable;

public class NumerateHuman implements Serializable {
    private int id;

    public int gethumanId() {
        return this.id++;
    }
}

