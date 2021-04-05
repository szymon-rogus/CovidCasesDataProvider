package covid.app.controllers;

import covid.app.model.jto.CountryHistoryJTO;
import covid.app.services.DeathsCasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("deaths")
public class DeathCasesController {

    @Autowired
    DeathsCasesService deathsCasesService;

    @RequestMapping("/all")
    public List<CountryHistoryJTO> getAll() {
        return deathsCasesService.getAllCountriesHistory();
    }

    @RequestMapping("/{country}")
    public List<CountryHistoryJTO> getCountry(@PathVariable String country) {
        return deathsCasesService.getCountryHistory(country);
    }
}
