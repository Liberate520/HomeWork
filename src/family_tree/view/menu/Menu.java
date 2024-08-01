package family_tree.view.menu;

import family_tree.view.View;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private ArrayList<command> arr;
    private View view;
    private Scanner scaner134;
    public Menu(View view){
        this.view = view;
        this.scaner134 = new Scanner(System.in);
        arr = new ArrayList<command>();
        arr.add(new Treeget(view));
        arr.add(new AddHuman(view));
        arr.add(new RemoveHuman(view));
        arr.add(new IdFind(view));
        arr.add(new NameFind(view));
        arr.add(new GetAncestors(view));
        arr.add(new getDescendants(view));
        arr.add(new SortByBirthday(view));
        arr.add(new SortByName(view));
        arr.add(new SaveTree(view));
        arr.add(new LoadTree(view));
        arr.add(new Exit(view));
    }
    public void Start(){
        StringBuilder sb = new StringBuilder();
        sb.append("Menu\n");
        for (int i = 0; i < arr.size(); i++){
            sb.append(i+1).append(". ").append(arr.get(i).getMessage()).append("\n");
        }
        view.printAnswer(sb.toString());
        String str = scaner134.nextLine();
        try{
            arr.get(Integer.parseInt(str)-1).startcommand();
        }
        catch (Exception e){
            view.printAnswer("Некорректный ввод!");
        }

    }
}
