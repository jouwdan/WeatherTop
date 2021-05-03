package models;

import javax.persistence.Entity;
import java.util.Date;
import play.db.jpa.Model;

@Entity
public class Reading extends Model {
    public Date date;
    public int code;
    public double temperature;
    public double windSpeed;
    public double windDirection;
    public int pressure;
    public double windChill;
    
    public Reading(Date date, int code, double temperature, double windSpeed, double windDirection, int pressure) {
        this.date = date;
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.pressure = pressure;
    }
}
