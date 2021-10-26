## Centralized Logging Using Log Streams
Using *Log Streams* is one way to implement centralized logging. The common way to implement it is to stream microservice logs to a common queue. Distributed logging server listens to the queue and acts as log store. It provides search capabilities to search the trace.

### Popular Implementations
1. Some of the popular implementations include the ELK stack (Elastic Search, Logstash and Kibana) for Centralized Logging.
2. Zipkin, Open Tracing API, and Zaeger for Distributed Tracing.
