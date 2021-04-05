package covid.app.services;

import covid.app.model.CountryRecoveredHistory;
import covid.app.services.url.UrlReader;
import covid.app.shared.UrlSources;
import org.springframework.stereotype.Service;

@Service
public class RecoveredCasesService extends AbstractCasesService {

    public RecoveredCasesService () {
        super();
        this.urlReader = new UrlReader(UrlSources.RECOVERED_SOURCE);
        this.countryHistory = new CountryRecoveredHistory();
    }
}
