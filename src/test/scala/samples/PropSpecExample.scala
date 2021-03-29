package samples

// scalastyle:off regex.println

import org.scalatest.{BeforeAndAfter, Matchers, PropSpec, Tag}
import org.scalatest.prop.TableDrivenPropertyChecks

import scala.collection.immutable._

object EmptyCheck extends Tag("samples.EmptyCheck")

// Reference: https://www.scalatest.org/scaladoc/3.0.9/org/scalatest/PropSpec.html
/**
 * Recommended Usage: Class PropSpec is a good fit for teams that want to
 * write tests exclusively in terms of property checks, and is also a good choice
 * for writing the occasional test matrix when a different style trait is
 * chosen as the main unit testing style.
 *
 * Running the tests
 * 1. From maven scala console: mvn scala:console
 * Within the scala console
 * {{{
 *  import org.scalatest
 *  import samples.PropSpecExample
 *  scalatest.run(new PropSpecExample)
 * }}}
 *
 * 2. Using scalatest. {{{mvn compile test -Dsuites="samples.PropSpecExample}}}
 */
class PropSpecExample
  extends PropSpec with TableDrivenPropertyChecks with Matchers with BeforeAndAfter {

  before {
    println("This will get executed before each test")
  }

  after {
    println("This will get executed after each test")
  }

  // Its better to have all the rows to have similar input types
  // In table the first row should be a heading
  // Then multiple rows of inputs can follow as tuples
  val testInputs = Table(
    ("set", "list"),
    (Set(1, 2, 3, 2, 1), List(1, 2, 3)),
    (Set.empty[Int], Nil)
  )

  property("set should be converted to list") {
    forAll(testInputs) {
      case (set, list) =>
        set.toList shouldEqual list
    }
  }

  val emptySets = Table(
    "emptysets",
    Set.empty[Int],
    HashSet.empty[Int],
    TreeSet.empty[Int]
  )

  // We can create tags and pass them to the property method
  // Tags are helpful while running the tests. Tests that have only certain tags can be run
  property("Empty set should throw Exception on accessing head", EmptyCheck) {
    forAll(emptySets) { (set) =>
      assertThrows[NoSuchElementException](set.head)
      a[NoSuchElementException] should be thrownBy { set.head }
    }

    // using markup we can pass text written in markdown to the test suite report
    markup("Empty Set checks **completed**")
  }

  val dummyTestInputs = Table(
    ("dummy_actual", "dummy_expected"),
    ("1", 1)
  )

  // This is how we disable tests
  ignore("Ignore this test for now") {
    forAll(dummyTestInputs) { (actual, exp) =>
      actual.toInt shouldBe exp
    }
  }

  // This is how we can write a test that's a TODO.
  property("This is a pending test") {
    pending
  }
}
