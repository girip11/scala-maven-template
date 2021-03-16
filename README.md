# scala-maven-template

Scala project using maven. We will be using the **scala maven plugin**. This plugin provides a scala archetype. An archetype is a general skeleton structure, or template for a project.

```Bash
mvn archetype:generate -DarchetypeGroupId=net.alchim31.maven -DarchetypeArtifactId=scala-archetype-simple
```

This will prompt us to enter details for artifactID etc.

## Useful Maven commands

* `mvn clean package` - compile and package
* `mvn scala:run -DmainClass=com.girish.playground.MainClass`
* `mvn scalastyle:check` - style checker
* `mvn scala:doc` - generates scaladoc
* `mvn clean compile test-compile scalafix:scalafix` - runs scalafix on the source. Requires compilation goal to precede it.
* `mvn test` - to run all tests
* `mvn test -Dparallel=true` - run tests in parallel
* `mvn test -DtagsToInclude=SizeTest` - Run by tags

To  use scalatest maven plugin, refer to the [usage page here](https://www.scalatest.org/user_guide/using_the_scalatest_maven_plugin)

---

## References

* [Scala with Maven](https://docs.scala-lang.org/tutorials/scala-with-maven.html)
* [Scala maven plugin](https://davidb.github.io/scala-maven-plugin/usage.html)
* [Maven assembly plugin](https://maven.apache.org/plugins/maven-assembly-plugin/) 
* [Maven lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)
