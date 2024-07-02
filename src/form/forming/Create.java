package form.forming;

import java.io.Serializable;
import java.util.List;
     public interface Create<T> extends Serializable {
        int getAge();

        List<T> getChildren();

        List<T> getParents();

        List<T> getGrandparents();

        List<T> getGrandsons();

        boolean alive();

        String toString();

        void setParents(Human mother, Human father);

        void setChildren(T child);

        String getName();

         String getSpouse();

         boolean addChild(T human);

         boolean addParents(T human);

         void setId(long l);

         void setSpouse(T human2);

         long getId();

         <T> Comparable<T> getGender();

         <T> Comparable<T> getBirthDate();
     }
