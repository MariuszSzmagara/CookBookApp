package mariusz.szmagara.cookbook.weather.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import mariusz.szmagara.cookbook.weather.dto.OpenWeatherMapOneCallDto;
import mariusz.szmagara.cookbook.weather.model.OpenWeatherMapCityNotFoundException;
import mariusz.szmagara.cookbook.weather.service.WeatherService;

@Controller
public class WeatherConditionsController {
    private final WeatherService weatherService;
    @Value("${open.weather.map.defaultCityName}")
    private String defaultCityName;

    public WeatherConditionsController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather/defaultCityName")
    public String getCurrentAndForecastWeatherDataForDefaultCityName(Model model) {
        OpenWeatherMapOneCallDto currentAndForecastSevenDaysWeatherData = weatherService.getWeatherConditions(defaultCityName);
        model.addAttribute("currentAndForecastSevenDaysWeatherData", currentAndForecastSevenDaysWeatherData);
        model.addAttribute("cityName", defaultCityName);
        return "forecastWeather";
    }

    @GetMapping("/weather/givenCityName")
    public String getCurrentAndForecastWeatherDataForCityName(@RequestParam String cityName, Model model) {
        OpenWeatherMapOneCallDto currentAndForecastSevenDaysWeatherData = weatherService.getWeatherConditions(cityName);
        model.addAttribute("cityName", cityName);
        model.addAttribute("currentAndForecastSevenDaysWeatherData", currentAndForecastSevenDaysWeatherData);
        return "forecastWeather";
    }

    @ExceptionHandler(OpenWeatherMapCityNotFoundException.class)
    public String getCurrentAndForecastWeatherDataForCityNameError(OpenWeatherMapCityNotFoundException exception, Model model) {
        model.addAttribute("OpenWeatherMapCityNotFoundException", exception);
        return "currentAndForecastWeather";
    }
}
