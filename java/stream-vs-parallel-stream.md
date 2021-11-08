# Stream vs Parallel Stream



|Stream|Parallel Stream|
|---|---|
| Use a single thread to process the pipelining|It uses multiple threads|
|it never takes the advantage of the multi-core system even though the underlying system supports parallel execution|Parallel stream leverage multi-core processors, which increases its performance.|
|Sequential stream performs operation one by one|It divides into multiple streams which can be executed parallelly on separate cores of the system and the final result is shown as the combination of all the individual core’s outcomes.|
||A parallel stream has a much higher overhead compared to a sequential one. Coordinating the threads takes a significant amount of time.|
||If a shared resource is used by the predicates and functions used in the process, you'll have to make sure that everything is thread-safe. In particular, side effects are things you really have to worry about if you go parallel.|
