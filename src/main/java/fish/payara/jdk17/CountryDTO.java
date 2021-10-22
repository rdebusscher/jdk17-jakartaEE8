package fish.payara.jdk17;

public record CountryDTO(String getName, String getContinentName) {
    // We need to use getxxx because the JSONB spec defines only 'getters' should be considered
    // Spec needs to be updated for records.

}
