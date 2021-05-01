package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Station;
import models.Reading;
import models.Member;
import play.Logger;
import play.mvc.Controller;

public class dashboard extends Controller {

    public static void index() {
        Logger.info("Rendering Dashboard");
        Member member = accounts.getLoggedInMember();
        List<Station> stations = member.stations;
        render ("dashboard.html", stations);
    }

    public static void addStation(String name, double lat, double lng) {
        Member member = accounts.getLoggedInMember();
        Station station = new Station(name, lat, lng);
        Logger.info ("Adding a new station called " + name);
        member.stations.add(station);
        member.save();
        redirect ("/dashboard");
    }

}