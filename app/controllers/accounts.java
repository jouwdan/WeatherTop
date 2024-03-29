package controllers;

import models.Member;
import play.Logger;
import play.mvc.Controller;

public class accounts extends Controller {
  public static void register() {
    render("register.html");
  }

  public static void login() {
    render("login.html");
  }

  public static void registration(String firstname, String lastname, String email, String password) {
    Logger.info("Registering new user " + email);
    Member member = new Member(firstname, lastname, email, password);
    member.save();
    redirect("/dashboard");
  }

  public static void authentication(String email, String password) {
    Logger.info("Attempting to authenticate with " + email + ":" + password);

    Member member = Member.findByEmail(email);
    if ((member != null) && (member.checkPassword(password) == true)) {
      Logger.info("Authentication successful");
      session.put("logged_in_Memberid", member.id);
      redirect("/dashboard");
    } else {
      Logger.info("Authentication failed");
      redirect("/login");
    }
  }

  public static void edit(Long id, String firstname, String lastname, String email, String password) {
    Logger.info("Editing User " + email);
    Member member = Member.findById(id);
    member.firstname = firstname;
    member.lastname = lastname;
    member.email = email;
    member.password = password;
    member.save();
    redirect("/myaccount");
  }

  public static void logout() {
    session.clear();
    redirect("/");
  }

  public static Member getLoggedInMember() {
    Member member = null;
    if (session.contains("logged_in_Memberid")) {
      String memberId = session.get("logged_in_Memberid");
      member = Member.findById(Long.parseLong(memberId));
    } else {
      login();
    }
    return member;
  }

  public static boolean checkForLogin() {
    boolean isLoggedIn;
    if (session.contains("logged_in_Memberid")) {
      isLoggedIn = true;
    } else {
      isLoggedIn = false;
    }
    return isLoggedIn;
  }
}