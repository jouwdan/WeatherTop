package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Station;
import models.Reading;

import play.Logger;
import play.mvc.Controller;

public class stationControl extends Controller {    
    public static void deleteReading (Long id, Long readingid) {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        Logger.info ("Deleting Reading: " + readingid);
        station.readings.remove(reading);
        station.save();
        reading.delete();
        render("station.html", station);
    }
}