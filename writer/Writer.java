package writer;

import family_tree.FamilyTree;

public interface Writer {

    public void write(FamilyTree obj, String fileName);

    public Object read(String fileName) throws ClassNotFoundException;

}