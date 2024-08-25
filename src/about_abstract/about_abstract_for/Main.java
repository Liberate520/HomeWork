package about_abstract.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(12);
//        list.add(123);
//        list.add(1234);
//        list.add(12345);
//
//        Iterator<Integer> iter = list.iterator();
//        while (iter.hasNext()){
//            System.out.println(iter.next());
//        }
//
//        Worker worker = new Worker("rfivv","vfmpf",12,2345566);
//        System.out.println(worker.fullname());

          Beverage latte = new Coffe();

          latte.addIngredients(new Milk("коровье"));
          latte.addIngredients(new Beans("big"));
          latte.addIngredients(new Woter("200"));

          Iterator<Ingredients> iterator = latte;
          while (iterator.hasNext()){
              System.out.println(iterator.next());
          }
    }
}
