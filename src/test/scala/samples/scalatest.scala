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
import org.scalatest.FlatSpec

class ListSpec extends FlatSpec {

  "A List" should "should be immutable" in {
    val list = List[Int](1, 2, 3, 4)
    assert(list.head === 1)
    assert(list.last === 4)
  }
}