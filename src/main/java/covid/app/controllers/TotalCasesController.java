package covid.app.controllers;

import covid.app.model.jto.CountryHistoryJTO;
import covid.app.services.TotalCasesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("total")
public class TotalCasesController {

    @Autowired
    TotalCasesService totalCasesService;

    @RequestMapping("/all")
    public List<CountryHistoryJTO> getAll() {
        return totalCasesService.getAllCountriesHistory();
    }

    @RequestMapping("/{country}")
    public List<CountryHistoryJTO> getCountry(@PathVariable String country) {
        return totalCasesService.getCountryHistory(country);
    }
}
