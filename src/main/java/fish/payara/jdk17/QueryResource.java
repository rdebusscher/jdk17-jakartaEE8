package fish.payara.jdk17;

import fish.payara.jdk17.model.Country;
import fish.payara.jdk17.service.CountryService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/query")
@ApplicationScoped
public class QueryResource {

    @Inject
    private CountryService countryService;

    @GET
    @Path("/countries/{continent}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CountryDTO> queryCountries(@PathParam("continent") String continent) {
        // Returns a list of record.
        return countryService.getCountries(continent);
    }

    @GET
    @Path("/country/olympic/{countryId}")
    @Produces(MediaType.TEXT_PLAIN)
    public String get(@PathParam("countryId") Long countryId) {
        // Incidental and intentional whitespaces
        var result = """
                    Olympic color for %s
                    is %s.
                """;
        var unknown = """
                    Olympic color is unknown
                    for country with id %s.
                """;
        Optional<Country> countryForId = countryService.getCountry(countryId);
        if (countryForId.isPresent()) {
            Country country = countryForId.get();
            // Switch expression
            var color = switch (country.getContinentName()) {
                case "South America", "North America" -> "Red";
                case "Asia" -> "Blue or Yellow";
                case "Europe" -> "Green";
                case "Africa" -> "Black";
                default -> throw new IllegalStateException("Unexpected value: " + country.getContinentName());
            };
            return String.format(result, country.getName(), color);
        } else {
            return String.format(unknown, countryId);
        }

    }
}
