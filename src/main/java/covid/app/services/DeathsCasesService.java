package covid.app.services;

import covid.app.model.CountryDeathsHistory;
import covid.app.services.url.UrlReader;
import covid.app.shared.UrlSources;
import org.springframework.stereotype.Service;

@Service
public class DeathsCasesService extends AbstractCasesService {

    public DeathsCasesService () {
        super();
        this.urlReader = new UrlReader(UrlSources.DEATHS_SOURCE);
        this.countryHistory = new CountryDeathsHistory();
    }
}
