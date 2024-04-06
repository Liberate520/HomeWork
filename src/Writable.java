

public interface Writable {

    boolean save(FamilyTree familyTree, String filePath);

    Object read(String filePath);
}
