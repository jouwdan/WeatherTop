package controllers;

import models.Member;
import play.Logger;
import play.mvc.Controller;

public class myAccount extends Controller {
  public static void index() {
    Logger.info("Rendering Account");
    Member member = accounts.getLoggedInMember();
    render("myaccount.html", member);
  }
}
