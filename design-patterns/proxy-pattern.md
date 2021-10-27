# Proxy Design Pattern
## Definition
The definition itself is very clear and proxy design pattern is used when we want to provide controlled access of a functionality.

Proxy is a structural design pattern that *provides an object that acts as a substitute for a real service object used by a client*. A proxy receives client requests, does some work (access control, caching, etc.) and then passes the request to a service object.

## When to use
Let’s say we have a class that can run some command(like cp, rm, mv) on the system. Now if we are using it, it's fine but if we want to give this program to a client application, it can have severe issues because client program can issue command to delete(rm) some system files or change some settings that you don’t want.

## Example