package mariusz.szmagara.cookbook.weather.dto;

import lombok.Data;
import mariusz.szmagara.cookbook.weather.model.Coordinates;

@Data
public class OpenWeatherMapCoordinatesDto {
    private Coordinates coord;
}
