package Family_Tree.Writer;

import Family_Tree.Human.Human;

import java.io.IOException;

public interface WriteTo {

    void save(Human human) throws IOException;

    void read(Human human) throws IOException, ClassNotFoundException;

}
