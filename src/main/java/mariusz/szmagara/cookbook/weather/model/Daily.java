package mariusz.szmagara.cookbook.weather.model;

import lombok.Data;

@Data
public class Daily {
    private Long dt;
    private Long sunrise;
    private Long sunset;
    private Temp temp;
    private TempFeelsLike feels_like;
    private int pressure;
    private int humidity;
    private double wind_speed;
    private int wind_deg;
    private Weather[] weather;
}
