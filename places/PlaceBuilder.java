package places;

public class PlaceBuilder {
    private Place place;
    private int homeNumber;
    private String street;
    private String region;
    private String country;
    private int postalCode;
    private String locality;

    public PlaceBuilder() {
        createPlace();
    }

    public PlaceBuilder setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
        return this;
    }

    public PlaceBuilder setStreet(String street) {
        this.street = street;
        return this;
    }

    public PlaceBuilder setRegion(String region) {
        this.region = region;
        return this;
    }

    public PlaceBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public PlaceBuilder setPostalCode(int postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public PlaceBuilder setLocality(String locality) {
        this.locality = locality;
        return this;
    }

    private void createPlace() {
        place = new Place();
    }

    private void createHomeNumber() {
        place.setHomeNumber(homeNumber);
    }

    private void createStreet() {
        place.setStreet(street);
    }

    private void createRegion() {
        place.setRegion(region);
    }

    private void createCountry() {
        place.setCountry(country);
    }

    private void createPostalCode() {
        place.setPostalCode(postalCode);
    }

    private void createLocality() {
        place.setLocality(locality);
    }

    public Place build() {
        createPlace();
        createHomeNumber();
        createStreet();
        createRegion();
        createCountry();
        createPostalCode();
        createLocality();
        return place;
    }

}
