package samples

import com.girish.playground.Foo
import org.scalatest.{FlatSpec, Matchers}
import org.scalamock.scalatest.MockFactory

/**
 * References: https://scalamock.org/quick-start/
 */
class ScalaMockExample extends FlatSpec with MockFactory with Matchers {

  "Foo" should "return mocked value for bar" in {
    val mockedFoo = mock[Foo]
    // pass the parameters of the method bar to expects
    (mockedFoo.bar _).expects().returning(6).once()
    mockedFoo.bar shouldEqual 6
  }
}
