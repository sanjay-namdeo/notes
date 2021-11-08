# Thread Locks

## Monitor-Objects
Used with synchronize keyword

## Reentrant Lock
A reentrant lock is a mutual exclusion mechanism that allows threads to reenter into a lock on a resource (multiple times) without a deadlock situation. A thread entering into the lock increases the hold count by one every time. ... Therefore, a resource is locked until the counter returns to zero

## Semaphores
Quite similar to Locks, but they provide a pool of permits which can be claimed to enter a critical section; a Semaphore with a single available Token works equivalent to a Lock
