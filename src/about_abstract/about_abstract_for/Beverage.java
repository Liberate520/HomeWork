package about_abstract.about_abstract_for;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Beverage implements Iterable<Ingredients> {
    List<Ingredients> components;
    int index;
    public Beverage() {
        components = new ArrayList<>();
        index = 0;
    }

    public void addIngredients(Ingredients component){
        components.add(component);
    }


  //  @Override
    public boolean hasNext() {
        return index<components.size();
    }

 //   @Override
    public Ingredients next() {
        return components.get(index++);
    }
}
