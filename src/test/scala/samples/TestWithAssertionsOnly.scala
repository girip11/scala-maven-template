package samples

import org.scalatest.Assertions._

object TestWithAssertionsOnly extends App {

  assert(List.empty.size == 0)

  assertThrows[IndexOutOfBoundsException] {
    List(1, 2, 3)(5)
  }

  // assertResult(expected)(actual)
  assertResult("Hello")(List("Hello", "World").head)
}
