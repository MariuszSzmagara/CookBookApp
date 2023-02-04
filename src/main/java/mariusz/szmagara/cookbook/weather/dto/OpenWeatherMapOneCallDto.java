package mariusz.szmagara.cookbook.weather.dto;

import lombok.Data;
import mariusz.szmagara.cookbook.weather.model.Current;
import mariusz.szmagara.cookbook.weather.model.Daily;
import mariusz.szmagara.cookbook.weather.model.Weather;

@Data
public class OpenWeatherMapOneCallDto {
    private double lat;
    private double lon;
    private String timezone;
    private Current current;
    private Weather[] weather;
    private Daily[] daily;


}
