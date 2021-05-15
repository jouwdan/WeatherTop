package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model {
  public String name, weatherCodeToString, windSpeedToBft, windDirectionToText, temperatureTrend, windSpeedTrend, pressureTrend;
  public double latitude, longitude, temperatureInFahrenheit, feelsLike, minTemp, maxTemp, minWindSpeed, maxWindSpeed, minPressure, maxPressure;

  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();

  public Station(String name, double latitude, double longitude) {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }
}
