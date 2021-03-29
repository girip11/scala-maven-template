package samples

//scalastyle:off regex.println

import org.scalatest.{BeforeAndAfter, FunSuite}

// FunSuite tests are similar to writing tests using XUnit
// Using FunSuite we can write TDD style unit tests
class FunSuiteExample extends FunSuite with BeforeAndAfter {

  before {
    println("This statement is executed before every test")
  }

  test("Empty list should have a size 0") {
    assert(List.empty.size == 0)
  }

  test("Accessing index longer than the list size should raise IndexOutOfBoundException") {
    assertThrows[IndexOutOfBoundsException] {
      List(1, 2)(3)
    }
  }

  // This can help us provide a placeholder to test something in the near future.
  test("To add some test in the future")(pending)

  after {
    println("This statement is executed after every test")
  }
}
