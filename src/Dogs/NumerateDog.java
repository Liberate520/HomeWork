package Dogs;

import java.io.Serializable;

public class NumerateDog implements Serializable {
    private int id;
    private static int dogcount = 0;

    public NumerateDog(){
        dogcount++;
        id = dogcount;
    }
    public int getdogId() {
        return this.id;

    }
}
