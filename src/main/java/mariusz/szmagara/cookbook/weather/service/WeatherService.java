package mariusz.szmagara.cookbook.weather.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import mariusz.szmagara.cookbook.weather.dto.OpenWeatherMapOneCallDto;
import mariusz.szmagara.cookbook.weather.model.Coordinates;
import mariusz.szmagara.cookbook.weather.dto.OpenWeatherMapCoordinatesDto;
import mariusz.szmagara.cookbook.weather.model.OpenWeatherMapCityNotFoundException;

@Service
public class WeatherService {
    @Value("${open.weather.map.API.key}")
    private String apiKey;
    @Value("${open.weather.map.API.call.parameters.optional.units}")
    private String units;

    public OpenWeatherMapOneCallDto getWeatherConditions(String cityName) {
        RestTemplate restTemplate = new RestTemplate();
        Coordinates coordinates = getCoordinatesFromCurrentWeatherDataResponse(cityName);
        return restTemplate.getForObject("https://api.openweathermap.org/data/2.5/onecall?lat={lat}&lon={lon}&exclude=minutely,hourly&units={units}&appid={apiKey}", OpenWeatherMapOneCallDto.class, coordinates.getLat(), coordinates.getLon(), units, apiKey);
    }

    private Coordinates getCoordinatesFromCurrentWeatherDataResponse(String cityName) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            OpenWeatherMapCoordinatesDto forObject = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}", OpenWeatherMapCoordinatesDto.class, cityName, apiKey);
            return forObject.getCoord();
        } catch (Exception exception) {
            throw new OpenWeatherMapCityNotFoundException(cityName);
        }
    }
}
