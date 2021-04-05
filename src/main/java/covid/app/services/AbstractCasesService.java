package covid.app.services;

import covid.app.model.CountryAbstractHistory;
import covid.app.model.jto.CountryHistoryJTO;
import covid.app.services.url.UrlReader;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public abstract class AbstractCasesService {

    protected UrlReader urlReader;
    protected CountryAbstractHistory countryHistory;

    public List<CountryHistoryJTO> getAllCountriesHistory() {
        List<List<String>> allData = urlReader.readFile();
        return allData.stream()
                .map(deaths -> countryHistory.getCountryHistory(deaths))
                .collect(Collectors.toList());
    }

    public List<CountryHistoryJTO> getCountryHistory(String country) {
        List<List<String>> allData = urlReader.readFile();
        return allData.stream()
                .map(data -> countryHistory.getCountryHistory(data))
                .filter(data -> data.getCountry().equals(country))
                .collect(Collectors.toList());
    }
}
