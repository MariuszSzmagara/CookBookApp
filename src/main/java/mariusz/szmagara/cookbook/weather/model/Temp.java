package mariusz.szmagara.cookbook.weather.model;

import lombok.Data;

@Data
public class Temp {
    private double day;

    public int getDay() {
        return (int) Math.round(day);
    }
}
