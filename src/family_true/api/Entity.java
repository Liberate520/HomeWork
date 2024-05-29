/**
 * @author Ostrovskiy Dmitriy
 * @created 29.05.2024
 * interface Entity
 * @version v1.0
 */

package family_true.api;

import family_true.human.Gender;

import java.time.LocalDate;
import java.util.List;

public interface Entity<T> extends BuildId {

    String getName();
    String getLastName();
    Gender getGender();
    LocalDate getBirthDay();
    LocalDate getDeathDay();
    T getMother();
    T getFather();
    List<T> getChildren();
    boolean isParent(T human);
}
