package mariusz.szmagara.cookbook.weather.model;

import lombok.Data;

@Data
public class Current {
    private Long dt;
    private Long sunrise;
    private Long sunset;
    private double temp;
    private double feels_like;
    private double pressure;
    private double humidity;
    private int wind_speed;
    private int wind_deg;
    private Weather[] weather;
    public int getTemp() {
        return (int) Math.round(temp);
    }

    public int getFeels_like() {
        return (int) Math.round(feels_like);
    }
}
