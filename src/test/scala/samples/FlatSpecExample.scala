package samples

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable.LinkedHashSet

/**
 * In actual fact, the ScalaTest project recommends using FlatSpec as the default
 * choice for writing unit tests.
 */
class FlatSpecExample extends FlatSpec with Matchers {

  //NOTE: Matchers provide a DSL for assertions

  "LinkedHashSet" should "preserve the order of insertion" in {
    val linkedHashSet = LinkedHashSet[Int]()
    linkedHashSet += 5
    linkedHashSet += 3
    linkedHashSet += 1

    // we could use equals or should be
    // equals we can customize the equality check
    linkedHashSet.last shouldEqual 1

    linkedHashSet.head should be(5)
    // This does not require parenthesis
    linkedHashSet.head shouldBe 5

    // For testing size of the collection
    linkedHashSet should have size 3
  }

  it should "throw NoSuchElementException is head is called on empty set" in {
    a[NoSuchElementException] should be thrownBy {
      LinkedHashSet[Int]().head
    }
  }

  //way to ignore a test
  ignore should "let us check a list is empty" in {
    List.empty shouldBe empty
  }

  // This test uses various forms of should for string assertion
  "SolarSystem" should "have the following planets" in {
    val planets =
      List("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    planets should not be empty
    planets should contain("Mars")

    val planetsText = planets.mkString(",")
    planetsText should include("Mars")
    planetsText should startWith("Mercury")
    planetsText should endWith("Neptune")
    planetsText should fullyMatch regex """M.*e"""

  }
}
