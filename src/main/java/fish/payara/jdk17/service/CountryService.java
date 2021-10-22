package fish.payara.jdk17.service;

import fish.payara.jdk17.CountryDTO;
import fish.payara.jdk17.model.Country;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class CountryService {

    @Inject
    private CountryBoundary countryBoundary;
    
    public List<CountryDTO> getCountries(String continent) {
        List<Country> countries = countryBoundary.getCountries();

        return countries.stream()
                .filter(c -> c.getContinentName().equalsIgnoreCase(continent))
                .map(c -> new CountryDTO(c.getName(), c.getContinentName()))
                .toList(); //collect(Collectors.toList());
                //.toList()  == unmodifiableList
    }

    public Optional<Country> getCountry(Long countryId) {
        List<Country> countries = countryBoundary.getCountries();
        return countries.stream()
                .filter(c -> c.getId().equals(countryId))
                .findAny();
    }
}
