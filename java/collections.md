### Primary Interfaces
1. public interface *Collection* extends Iterable
2. public interface *List* extends Collection<E>
3. public interface *Set* extends Collection<E>
4. public interface *Queue* extends Collection<E>

### Hashmap vs ConcurrentHashMap
1. HashMap is the Class which is under Traditional Collection and ConcurrentHashMap is a Class which is under Concurrent Collections
2. HashMap is non-Synchronized in nature i.e. HashMap is not Thread-safe whereas ConcurrentHashMap is Thread-safe in nature.
3. HashMap performance is relatively high because it is non-synchronized in nature and any number of threads can perform simultaneously. But ConcurrentHashMap performance is low sometimes because sometimes Threads are required to wait on ConcurrentHashMap.
4. *HashMap iterator is fail-fast* and throws ConcurrentModificationException if concurrent modification happens during iteration. *ConcurrentHashMap is fail-safe* and it will never throw ConcurrentModificationException during iteration.

### ConcurrentHashMap
1. You should use ConcurrentHashMap when you need very high concurrency in your project.
2. It is thread safe without synchronizing the whole map.
3. Reads can happen very fast while write is done with a lock.
4. There is no locking at the object level.
5. The locking is at a much finer granularity at a hashmap bucket level.
6. ConcurrentHashMap does not throw a ConcurrentModificationException if one thread tries to modify it while another is iterating over it.
7. ConcurrentHashMap uses multitude of locks.

### SynchronizedHashMap
1. Synchronization at Object level.
2. Every read/write operation needs to acquire lock.
3. Locking the entire collection is a performance overhead.
4. This essentially gives access to only one thread to the entire map & blocks all the other threads. It may cause contention.
5. SynchronizedHashMap returns Iterator, which fails-fast on concurrent modification.
