package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class dashboard extends Controller {

    public static void index() {
        Logger.info("Rendering Dashboard");
        List<Station> stations = Station.findAll();
        render ("dashboard.html", stations);
    }

    public static void addStation(String name, double lat, double lng) {
        Station station = new Station(name, lat, lng);
        Logger.info ("Adding a new station called " + name);
        station.save();
        redirect ("/dashboard");
    }

}