package covid.app.controllers;

import covid.app.model.jto.CountryHistoryJTO;
import covid.app.services.RecoveredCasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("recovered")
public class RecoveredCasesController {

    @Autowired
    RecoveredCasesService recoveredCasesService;

    @RequestMapping("/all")
    public List<CountryHistoryJTO> getAll() {
        return recoveredCasesService.getAllCountriesHistory();
    }

    @RequestMapping("/{country}")
    public List<CountryHistoryJTO> getCountry(@PathVariable String country) {
        return recoveredCasesService.getCountryHistory(country);
    }
}
