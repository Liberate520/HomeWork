package family_free.writer;

import family_free.human.Human;

public interface Writer {
    void write(Object human);
    Object read();
}
