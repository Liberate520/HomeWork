public interface Writer {

    public void write(FamilyTree obj, String fileName);

    public Object read(String fileName) throws ClassNotFoundException;

}