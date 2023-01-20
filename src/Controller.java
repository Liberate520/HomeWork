import java.util.List;

public class Controller<T extends LiveBeing<T>> {
    private String line;
    T liveBeing;
    private List<T> list;
    private String filePath;
    private FamilyTree<T> familyTree;
    private FamilyTreeView<T> familyTreeView;
    private InputOutputList<T> inputOutput;

    public Controller(FamilyTree<T> familyTree, String filePath) {
        this.filePath = filePath;
        this.familyTree = familyTree;
        this.familyTreeView = new FamilyTreeView<>(this);
        this.inputOutput = new InputOutputList<>();
    }

    void start() {
        while (true) {
            familyTreeView.menu();
            int value = familyTreeView.getValue();
            switch (value) {
                case 1:
                    showAllLiveBeings();
                    break;
                case 2:
                    showAllSortByName();
                    break;
                case 3:
                    showAllSortByDate();
                    break;
                case 4:
                    showOneByName();
                    break;
                case 5:
                    showAllByName();
                    break;
                case 6:
                    saveToBin();
                    break;
                case 7:
                    loadFromBin();
                    break;
                case 0:
                    exit();
                    break;
                default:

                    break;
            }
        }
    }

    // 1
    public void showAllLiveBeings() {
        list = familyTree.getLiveBeings();
        familyTreeView.showAllInConsole(list);
    }

    // 2
    public void showAllSortByName() {
        list = familyTree.sortByName();
        familyTreeView.showAllInConsole(list);
    }

    // 3
    public void showAllSortByDate() {
        list = familyTree.sortByDate();
        familyTreeView.showAllInConsole(list);
    }

    // 4
    public void showOneByName() {
        line = familyTreeView.getName();
        liveBeing = familyTree.findByName(line);
        familyTreeView.showLiveBeing(liveBeing);
    }

    // 5
    public void showAllByName() {
        line = familyTreeView.getName();
        list = familyTree.findAllByName(line);
        familyTreeView.showAllInConsole(list);
    }

    // 6
    public void saveToBin() {
        familyTreeView.showSaveTree(list);
        inputOutput.saveToBin(familyTree, filePath);
    }

    // 7
    public void loadFromBin() {
        list = inputOutput.loadFromBin(filePath);
        familyTreeView.showLoadTree(list);
    }

    // 0
    public void exit() {
        familyTreeView.exit();
        System.exit(0);
    }

}
