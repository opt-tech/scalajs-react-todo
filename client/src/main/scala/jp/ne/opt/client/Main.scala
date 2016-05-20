package jp.ne.opt.client

import jp.ne.opt.domain.TodoStore

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import japgolly.scalajs.react.{ReactComponentB, ReactDOM}
import japgolly.scalajs.react.vdom.prefix_<^._
import org.scalajs.dom.document

object TutorialApp extends JSApp {
  def main(): Unit = {
    println("helloWorld")
  }

  @JSExport
  def count():Unit = {
    countNumber +=1
    println(countNumber)
  }
  var countNumber: Int = 1

  val Hello =
    ReactComponentB[String]("Hello")
      .render_P(name => <.div(^.id:="hoge","Hello there ", name))
      .build

  ReactDOM.render(Hello("hohohohoho"), document.getElementById("content"))
}

