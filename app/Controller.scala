package com.lucidchart

import play.api.mvc._

class Controller() extends play.api.mvc.Controller {

  def okExpires() = Action { request =>
    Ok.discardingCookies(DiscardingCookie("test"))
  }

  def badExpires() = Action { request =>
    Ok.discardingCookies(DiscardingCookie("test")).withCookies(Cookie("other", "value"))
  }

}
