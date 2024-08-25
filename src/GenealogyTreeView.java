interface GenealogyTreeView {
    void showGenealogyTree(GenealogyTree tree);

    void addButtonClickListener(Runnable listener);

    void addSortByNameButtonClickListener(Runnable listener);

    void addSortByBirthDateButtonClickListener(Runnable listener);

    void addSaveButtonClickListener(Runnable listener);

    void addLoadButtonClickListener(Runnable listener);

    Person getPersonInput();
}
