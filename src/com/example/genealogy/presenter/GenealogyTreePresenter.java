package com.example.genealogy.presenter;

import java.util.List;

import com.example.genealogy.model.GenealogyTreeModel;
import com.example.genealogy.model.Person;
import com.example.genealogy.view.GenealogyTreeView;

public class GenealogyTreePresenter {

    private GenealogyTreeModel model;
    private GenealogyTreeView view;

    public GenealogyTreePresenter(GenealogyTreeModel model, GenealogyTreeView view) {
        this.model = model;
        this.view = view;
    }

    public void loadData() {
        
        view.displayData(model.getPeople());
    }

    public void sortByName() {
        model.sortByName();

        view.displaySortedByName(model.getPeople());
    }

    public void sortByDateOfBirth() {
        model.sortByDateOfBirth();

        view.displaySortedByDateOfBirth(model.getPeople());
    }

    public List<Person> getSortedByName() {
        return model.getPeople();
    }

    public List<Person> getSortedByDateOfBirth() {
        return model.getPeople();
    }

}
