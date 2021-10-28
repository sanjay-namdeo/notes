# Maven Parent Child Relationship
Maven parent POM(OR Super POM) is used to structure the project to **avoid redundancies or duplicate configurations** using **inheritance** between pom files. It helps in easy maintenance in long term.
> If any dependency or property is configured in both parent and child POMs with different values, then the child POM value will take the priority.

## Parent POM
A parent POM can be **declared with packaging pom**. It is not meant to be distributed because it is only referenced from other projects.

Maven parent pom can contain almost everything and those can be inherited into child pom files for example:
1. Common data - Developer's name, SCM address, distribution management etc.
2. Constants - Such as version numbers
3. Common dependencies - Common to all child. It has the same effect as writing them several times in individual pom files.
4. Properties - For example plugins, declarations, executions and IDs.
5. Configurations
6. Resources

## Child POM
A child POM needs to refer the parent POM using **parent tag and specifying groupId/artifactId/version**. This pom file will inherit all properties and dependencies from parent POM and additionally can include extra sub-project specific dependencies as well.

## Parent Matching
To match a parent POM, Maven uses two rules:
1. There is a **pom file in project's root directory** or in given relative path.
2. Reference from **child POM file contains the same coordinates as stated in the parent POM** file.
