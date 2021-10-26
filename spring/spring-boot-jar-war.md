## How to Deploy Spring Boot Web Applications as Jar and War Files?

Traditionally, we package a web application as a WAR file, then deploy it into an external server. Doing this allows us to arrange multiple applications on the same server. During the time that CPU and memory were scarce, this was a great way to save resources.
However, things have changed. Computer hardware is fairly cheap now, and the attention has turned to server configuration. A small mistake in configuring the server during deployment may lead to catastrophic consequences.

Spring tackles this problem by providing a plugin, namely `spring-boot-maven-plugin`, to package a web application as an executable JAR. To include this plugin, just add a plugin element to pom.xml:

```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
```

With this plugin in place, we'll get a fat JAR after executing the package phase. This JAR contains all the necessary dependencies, including an embedded server. Thus, we no longer need to worry about configuring an external server.
We can then run the application just like we would an ordinary executable JAR.

Notice that the packaging element in the pom.xml file must be set to jar to build a JAR file:

```xml
<packaging>jar</packaging>
```

If we don't include this element, it also defaults to jar.
In case we want to build a WAR file, change the packaging element to war:
```xml
<packaging>war</packaging>
```
And leave the container dependency off the packaged file:
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-tomcat</artifactId>
    <scope>provided</scope>
</dependency>
```
After executing the Maven package phase, we'll have a deployable WAR file.
