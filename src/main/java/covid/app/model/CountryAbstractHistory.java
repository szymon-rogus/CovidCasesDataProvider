package covid.app.model;

import covid.app.model.jto.CountryHistoryJTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public abstract class CountryAbstractHistory {
    private final int INDEX = 0;

    public CountryHistoryJTO getCountryHistory(List<String> data) {
        return CountryHistoryJTO.builder()
                .province(data.remove(getINDEX()))
                .country(data.remove(getINDEX()))
                .latitude(getDoubleValueFromString(data.remove(getINDEX())))
                .longitude(getDoubleValueFromString(data.remove(getINDEX())))
                .statistics(data)
                .build();
    }

    private double getDoubleValueFromString(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
