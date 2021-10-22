package fish.payara.jdk17.json;

import fish.payara.jdk17.model.Continent;
import fish.payara.jdk17.model.Country;

import java.util.List;

public class Data {

    private List<Continent> continents;
    private List<Country> countries;

    public void setContinents(List<Continent> continents) {
        this.continents = continents;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public List<Continent> getContinents() {
        return continents;
    }

    public List<Country> getCountries() {
        return countries;
    }
}
