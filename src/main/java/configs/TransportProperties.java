package configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Antony Genil on 2019-06-27 at 21 20 for licensing-service
 **/
@Component
@ConfigurationProperties("transport")
public class TransportProperties {
    private List<Country> countries = new ArrayList<>();

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public Map<String, Country> getCountryMap() {
        List<Country> countries = getCountries();
        Map<String, Country> countryMap = countries.stream()
                .collect(Collectors.toMap(Country::getName, Function.identity()));
        return countryMap;
    }

}
