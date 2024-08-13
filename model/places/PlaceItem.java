package model.places;

public interface PlaceItem<P> extends Comparable<P> {
    String getInfo();

    void setId(long id);
}
