package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class dashboard extends Controller {

    public static void index() {
        render ("dashboard.html");
    }

}