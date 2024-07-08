import java.io.IOException;
import java.util.List;

public interface Writer {
    void save(List<HumanInfo> people, String path) throws IOException;
    List<HumanInfo> load(String path) throws IOException, ClassNotFoundException;
}