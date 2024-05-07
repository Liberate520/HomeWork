package Main.java;

import java.util.List;

import com.example.genealogy.model.GenealogyTreeModel;
import com.example.genealogy.model.Person;
import com.example.genealogy.view.GenealogyTreeView;
import com.example.genealogy.presenter.GenealogyTreePresenter;

public class Main {

    public static void main(String[] args) {
        GenealogyTreeModel model = new GenealogyTreeModel(new Person("Иван", null));

        GenealogyTreeView view = new GenealogyTreeView();

        GenealogyTreePresenter presenter = new GenealogyTreePresenter(model, view);

        presenter.loadData();

        model.addPerson(new Person("Мария", model.getRootPerson()));

        model.addPerson(new Person("Алексей", model.getRootPerson()));
        model.addPerson(new Person("Екатерина", model.getRootPerson()));
        model.addPerson(new Person("Мария", model.getRootPerson()));
        model.addPerson(new Person("Петр", model.getRootPerson()));
        model.addPerson(new Person("Анна", model.getRootPerson()));

        presenter.sortByName();

        List<Person> sortedByName = presenter.getSortedByName();

        view.displaySortedByName(sortedByName);

        presenter.sortByDateOfBirth();

        List<Person> sortedByDateOfBirth = presenter.getSortedByDateOfBirth();

        view.displaySortedByDateOfBirth(sortedByDateOfBirth);
    }
}

