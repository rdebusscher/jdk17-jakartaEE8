package fish.payara.jdk17.service;

import fish.payara.jdk17.json.Data;
import fish.payara.jdk17.model.Country;
import fish.payara.jdk17.model.DataRoot;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.json.bind.JsonbBuilder;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class CountryBoundary {

    private DataRoot dataRoot;

    @PostConstruct
    public void init() {

        InputStream jsonStream = CountryBoundary.class.getResourceAsStream("/data.json");
        String text = new BufferedReader(
                new InputStreamReader(jsonStream, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));

        Data data = JsonbBuilder.create().fromJson(text, Data.class);

        dataRoot = new DataRoot(data.getCountries());

    }

    public List<Country> getCountries() {
        return dataRoot.getCountries();
    }
}
