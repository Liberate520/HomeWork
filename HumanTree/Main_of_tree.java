import java.io.Serializable;

import Controller.Controller;
import Model.HumanTreeModel;
import Model.Model;
import View.View;

public class Main_of_tree  implements Serializable{
    public static void main(String[] args) {
        Model humanTreeModel = new HumanTreeModel();        
        View view = new View();
        Controller controller = new Controller(view, humanTreeModel);
        view.start();
        
        // System.out.println(firstHuman.toString());
        // System.out.println(humanTree.getHumanList());
        // System.out.println(thirdHuman.getFather());
        // System.out.println(humanTree.getChild(firstHuman));
        // System.out.println(humanTree.getSistBroth(fourthHuman));  
        // firstHuman.write();
        // firstHuman.read();
        // System.out.println(firstHuman.toString());      

        // for (Human human: humanTree){
        //     System.out.println(human);
        // }
        // System.out.println();
        // humanTree.sortByName();

        // for (Human human: humanTree){
        //     System.out.println(human);
        // }

        // System.out.println();
        // humanTree.sortByBirth();

        // for (Human human: humanTree){
        //     System.out.println(human);
        // }

    }
}
