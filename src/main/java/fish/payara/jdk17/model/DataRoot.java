package fish.payara.jdk17.model;

import java.util.List;

public class DataRoot {

    private List<Country> countries;

    public DataRoot(List<Country> countries) {
        this.countries = countries;
    }

    public List<Country> getCountries() {
        return countries;
    }
}
