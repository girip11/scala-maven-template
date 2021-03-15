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
import org.scalatest.{FunSpec, Matchers}

// Used in Behavior Driven Development.
class FunSpecExample extends FunSpec with Matchers {
  // we can use describe with it or they
  // In tests we could either use asserts or matchers which provided clauses like should be
  // should be thrownBy etc

  describe("A Set") {
    describe("when empty") {
      it("should have size 0") {
        assert(Set.empty.size === 0)
      }

      it("should produce NoSuchElementException when head is invoked") {
        a[NoSuchElementException] should be thrownBy {
          Set.empty.head
        }
      }
    }
  }
}
