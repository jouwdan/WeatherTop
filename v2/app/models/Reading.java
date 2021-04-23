package models;

import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity
public class Reading extends Model {
    public int code;
    public double temperature;
    public double windSpeed;
    public int pressure;

    public Reading(int code, double temperature, double windSpeed, int pressure) {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
    }
}
