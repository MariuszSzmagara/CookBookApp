package mariusz.szmagara.cookbook.weather.model;

import lombok.Data;

@Data
public class TempFeelsLike {
    private double day;

    public int getDay() {
        return (int) Math.round(day);
    }
}
