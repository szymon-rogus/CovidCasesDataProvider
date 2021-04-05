package covid.app.model.jto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import org.springframework.lang.NonNull;

import java.util.List;

@Builder
@Getter
public class CountryHistoryJTO {
    @JsonProperty
    private String province;

    @NonNull
    @JsonProperty
    private String country;

    @JsonProperty
    private double latitude;

    @JsonProperty
    private double longitude;

    @JsonProperty
    private List<String> statistics;
}