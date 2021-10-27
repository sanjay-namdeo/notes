## Spring Bean Autowiring
1. `byName` Spring container looks at the properties of the beans on which *autowire* attribute is set to byName in the XML configuration file. It then tries to match and wire its properties with the beans defined by the same name in the configuration file.
2. `byType` Spring container looks at the properties of the beans on which *autowire* attribute is set to byType in the XML configuration file. It then tries to match and wire a property by its *type*. If more than one beans of that type exists, a fatal exception is thrown.
3. `Constructor` Similar to byType, but type applies to constructor arguments. If there is not exactly one bean of the constructor argument type in the container, a fatal error is raised.
