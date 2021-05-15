package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

import models.Station;
import models.Reading;
import models.Member;
import utils.WeatherUtility;
import play.Logger;
import play.mvc.Controller;

public class dashboard extends Controller {

  public static void index() {
    Logger.info("Rendering Dashboard");
    Member member = accounts.getLoggedInMember();
    List<Station> stations = member.stations;

    // stackoverflow link used to get this working: https://stackoverflow.com/a/44096027
    Collections.sort(stations, new Comparator<Station>() {
      public int compare(Station station, Station t1) {
        String s1 = station.name;
        String s2 = t1.name;
        return s1.compareToIgnoreCase(s2);
      }
    });

    for (Station station : member.stations) {
      WeatherUtility.updateWeather(station);
    }
    render("dashboard.html", member, stations);
  }

  public static void addStation(String name, double lat, double lng) {
    Member member = accounts.getLoggedInMember();
    Station station = new Station(name, lat, lng);
    Logger.info("Adding a new station called " + name);
    member.stations.add(station);
    member.save();
    redirect("/dashboard");
  }

  public static void deleteStation(Long id) {
    Station station = Station.findById(id);
    Member member = accounts.getLoggedInMember();
    Logger.info("Deleting Station: " + station.name);
    member.stations.remove(station);
    member.save();
    station.delete();
    redirect("/dashboard");
  }
}