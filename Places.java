public class Places {
    protected int homeNumber;
    protected String street;
    protected String region;
    protected String country;
    protected int postalCode;

    public Places(int homeNumber, String street, String region, String country, int postalCode) {
        this.homeNumber = homeNumber;
        this.street = street;
        this.region = region;
        this.country = country;
        this.postalCode = postalCode;
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

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Страна: ");
        sb.append(country);
        sb.append(", Область: ");
        sb.append(region);
        sb.append(", Улица: ");
        sb.append(street);
        sb.append(", Дом: ");
        sb.append(homeNumber);
        sb.append(", Индекс: ");
        sb.append(postalCode);
        return sb.toString();
    }

}
