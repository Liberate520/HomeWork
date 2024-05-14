package Main.java;
import com.example.genealogy.view.*;
import com.example.genealogy.model.*;

public class Main {

    public static void main(String[] args) {
        GenealogyService genealogyService = new GenealogyService (null);
        GenealogyView genealogyView = new GenealogyView(genealogyService);
        genealogyView.runConsole();
    }
}

