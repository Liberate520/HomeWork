package model.places;

import java.io.Serializable;
import java.util.Objects;

public class Place implements Serializable, PlaceItem<Place> {
    private long id;
    private int homeNumber;
    private String street;
    private String region;
    private String country;
    private int postalCode;
    private String locality;

    public Place() {
    }

    public Place(int homeNumber, String street, String region, String country, int postalCode, String locality) {
        this.id = -1;
        this.homeNumber = homeNumber;
        this.street = street;
        this.region = region;
        this.country = country;
        this.postalCode = postalCode;
        this.locality = locality;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ");
        sb.append(id);
        sb.append("Страна: ");
        sb.append(country);
        sb.append(", Область: ");
        sb.append(region);
        sb.append(", Населенный пункт: ");
        sb.append(locality);
        sb.append(", Улица: ");
        sb.append(street);
        sb.append(", Дом: ");
        sb.append(homeNumber);
        sb.append(", Индекс: ");
        sb.append(postalCode);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Place place = (Place) o;
        return id == place.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Place o) {
        return Long.compare(this.id, o.id);
    }
}