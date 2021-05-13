package controllers;

import models.Member;
import play.Logger;
import play.mvc.Controller;

public class about extends Controller {
  public static void index() {
    Logger.info("Rendering About");
    render("about.html");
  }
}
