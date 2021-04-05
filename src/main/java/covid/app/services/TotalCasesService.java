package covid.app.services;

import covid.app.model.CountryTotalHistory;
import covid.app.services.url.UrlReader;
import covid.app.shared.UrlSources;
import org.springframework.stereotype.Service;

@Service
public class TotalCasesService extends AbstractCasesService {

    public TotalCasesService () {
        super();
        this.urlReader = new UrlReader(UrlSources.TOTAL_SOURCE);
        this.countryHistory = new CountryTotalHistory();
    }
}
