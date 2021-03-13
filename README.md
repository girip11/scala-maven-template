# scala-maven-template

Scala project using maven. We will be using the **scala maven plugin**. This plugin provides a scala archetype. An archetype is a general skeleton structure, or template for a project.

```Bash
mvn archetype:generate -DarchetypeGroupId=net.alchim31.maven -DarchetypeArtifactId=scala-archetype-simple
```

This will prompt us to enter details for artifactID etc.

## Useful Maven commands

* `mvn clean package`
* `mvn scala:run -DmainClass=com.girish.playground.MainClass`

---

## References

* [Scala with Maven](https://docs.scala-lang.org/tutorials/scala-with-maven.html)
* [Scala maven plugin](https://davidb.github.io/scala-maven-plugin/usage.html)
* [Maven assembly plugin](https://maven.apache.org/plugins/maven-assembly-plugin/) 
* [Maven lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html)
