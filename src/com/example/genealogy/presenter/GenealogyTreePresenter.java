import java.util.List;
import com.example.genealogy.model.GenealogyTree;
import com.example.genealogy.model.Person;
import com.example.genealogy.view.GenealogyView;
import com.example.genealogy.filehandler.FileHandlerInterface;

public class GenealogyTreePresenter {

    private GenealogyTree model;
    private GenealogyView view;
    private FileHandlerInterface fileHandler;

    public GenealogyTreePresenter(GenealogyTree model, GenealogyView view, FileHandlerInterface fileHandler) {
        this.model = model;
        this.view = view;
        this.fileHandler = fileHandler;
    }

    public void loadData() {
        
        view.displayData(model.getAllPeople());
    }

    public void sortByName() {
        model.sortByName();
        view.displaySortedByName(model.getAllPeople());
    }

    public void sortByDateOfBirth() {
        model.sortByDateOfBirth();

        view.displaySortedByDateOfBirth(model.getAllPeople());
    }

    public void saveTree(String filename) {
        fileHandler.saveTree(model, filename);
    }

    public void loadTree(String filename) {
        model = fileHandler.loadTree(filename);
        view.displayData(model.getAllPeople());
    }

    public List<Person> getSortedByName() {
        return model.getAllPeople();
    }

    public List<Person> getSortedByDateOfBirth() {
        return model.getAllPeople();
    }

}
