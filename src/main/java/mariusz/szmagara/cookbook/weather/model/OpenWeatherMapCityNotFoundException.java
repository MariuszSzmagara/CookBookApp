package mariusz.szmagara.cookbook.weather.model;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Not found")
public class OpenWeatherMapCityNotFoundException extends RuntimeException {

    public OpenWeatherMapCityNotFoundException(String cityName) {
        super("City by given name: " + cityName + " was not found!");
    }
}