/*
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package samples

/*
ScalaTest facilitates different styles of testing by providing traits you can mix
together to get the behavior and syntax you prefer.  A few examples are
included here.  For more information, visit:

http://www.scalatest.org/

One way to use ScalaTest is to help make JUnit or TestNG tests more
clear and concise. Here's an example:
 */
import org.scalatest.{FunSpec, Matchers, Tag}

// This is how we define a scalatest tag
object SizeTest extends Tag("SizeTest")

// Used in Behavior Driven Development.
class FunSpecExample extends FunSpec with Matchers {
  // we can use describe with it or they
  // In tests we could either use asserts or matchers which provided clauses like should be
  // should be thrownBy etc

  describe("A Set") {
    describe("when empty") {
      it("should have size 0", SizeTest) {
        // using === prints the actual and expected when the test fails
        assert(Set.empty.size === 0)
      }

      // TODO tests are written using pending
      it("should have tail pointing to empty set", SizeTest)(pending)

      it("should have size 0 (intentionally failing)", SizeTest) {
        //using assertResult also prints the actual and expected
        assertResult(1) {
          Set.empty.size
        }
      }

      it("should produce NoSuchElementException when head is invoked") {
        // This is one way of checking
        a[NoSuchElementException] should be thrownBy {
          Set.empty.head
        }

        // intercept can be used to catch the exception and inspect it
        // if the enclosing code does not throw the expected exception, the test fails
        val ex = intercept[NoSuchElementException] {
          Set.empty.head
        }

        assertResult(classOf[NoSuchElementException]) {
          ex.getClass
        }
      }
    }
  }
}
