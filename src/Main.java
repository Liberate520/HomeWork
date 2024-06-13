import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.time.LocalDate;
import java.util.Scanner;

import Family_tree.Model.HumanService;
import Family_tree.Model.Service;
import Family_tree.Model.Humans.*;
import Family_tree.Model.Tree.Family_tree;
import Family_tree.View.*;

public class Main {
    

    public static void main(String[] args) throws IOException {
      
      
      Human Volkov = new Human("Александр", Gender.Male, LocalDate.of(1972,1,2));
      Human Volkova = new Human("Александра", Gender.Female, LocalDate.of(1974,1,12));
      View<Human> view = new HumanView();
      view.start();

      
    }
}