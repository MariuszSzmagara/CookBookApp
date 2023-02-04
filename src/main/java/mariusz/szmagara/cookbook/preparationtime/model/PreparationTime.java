package mariusz.szmagara.cookbook.preparationtime.model;

import java.io.Serializable;

public class PreparationTime implements Serializable {
    private int value;
    private TimeUnit timeUnit;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }
}
