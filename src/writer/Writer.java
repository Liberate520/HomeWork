package writer;

import familyTree.FamilyTree;

import java.io.IOException;

public interface Writer {

     void WriteObject(FamilyTree ft, String file_name) throws IOException;
     FamilyTree ReadObject(String file_name) throws IOException, ClassNotFoundException;
}
