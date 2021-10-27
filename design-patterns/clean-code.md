# Clean Code
Clean code can be summarized as `a code that any developer can read and change easily`
While this may sound like an oversimplification of the concept, we'll see later in the tutorial how this builds up. Anywhere we hear about clean code, we perhaps come across some reference to Martin Fowler. Here is how he describes clean code in one of the places:

> Any fool can write code that a computer can understand. Good programmers write code that humans can understand.

## Why Should We Care About Clean Code?
1. `Maintainable Codebase`:  can help develop software that is easy to change and maintain over time.
2. `Easier Troubleshooting`:  is easier to troubleshoot for problems.
3. `Faster Boarding`:  a quicker boarding to keep productivity high, and clean code helps achieve this goal.

## Characteristics of Clean Code
1. `Focused:`  code should be written to solve a specific problem.
2. `Simple:`  design and implementation must be as simple as possible
3. `Testable:`  intuitive and easy to test the codebase, preferably in an automated manner.

## Project Structure
Follow a `consistent pattern to organize our source files, tests, configurations, data, and other code artifacts`. Let's see some of the folders that Maven suggests we create:
1. `src/main/java`: For source files
2. `src/main/resources`: For resource files, like properties
3. `src/test/java`: For test source files
4. `src/test/resources`: For test resource files, like properties

## Naming Convention
>“… if you know what something does, you got a pretty good chance guessing the name of the Spring class or interface for it …”

1. Class name should be noun. e.g. Customer
2. Method name should be verbs e.g. withdraw(); deposit();
3. Variable name should describe intent clearly: e.g. customerName
4. Constants should be all upper case with words separated by underscore("_"): `MIN_WIDTH = 1`

## Code Comments
1. Beneficial while reading code to understand the non-trivial aspects
2. Do not include obvious things in the comments
3. Comments should only complement a code, if we are not able to understand the code without comments, perhaps we need to refactor ii
4. We should use block comments rarely, possibly to describe non-trivial design decisions
5. We should use JavaDoc comments for most of our classes, interfaces, public and protected methods
6. All comments should be well-formed with a proper indentation for readability

## Logging
1. Importance of logs can not be over-emphasized in development in general and maintenance in particular.
2. Avoid excessive logging, think about what information might be of help in troubleshooting
3. Choose log levels wisely, we may want to enable log levels selectively on production
4. Be very clear and descriptive with contextual data in the log message
5. Use external tools for tracing, aggregation, filtering of log messages for faster analytics