public class NumerateHuman {
    private int id;
    private static int humancount = 0;

    public NumerateHuman(){
        humancount++;
        id = humancount;
    }
    public int gethumanId() {
        return this.id;

    }
}
