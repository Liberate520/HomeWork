package writers;

public interface Writer {
    void write(Object obj);

    Object read();
}