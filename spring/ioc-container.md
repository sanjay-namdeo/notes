# Spring IoC Container
IoC is also known as dependency injection

> Inversion of Control (IoC) is the mechanism to achieve loose-coupling between Objects dependencies.

Objects define their dependencies, that is, the other objects they work with, only through constructor arguments, arguments to a method, or properties that are set on the object instance after it is constructed or returned from a factory method.

The container then injects those dependencies when it creates the bean. This process is fundamentally the inverse, hence the name /Inversion of Control (IoC)/. The packages org.springframework.beans and org.springframework.context are the basis for Spring Framework's IoC container.

`ApplicationContext` represents the Spring IoC container and is responsible for instantiating, configuring and assembling the aforementioned beans. Example implementations are `ClassPathXmlApplicationContext` or `FileSystemXmlApplicationContext`