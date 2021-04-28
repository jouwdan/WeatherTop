package controllers;

import play.Logger;import play.mvc.Controller;

public class home extends Controller {
    public static void index() {
        Logger.info("Rendering Home");
        render ("home.html");
    }
}
