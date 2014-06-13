[Double-Checked Locking pattern](https://github.com/victorakamon/pattern-design/blob/master/src/creational/singletonthreadsafe/src/SingletonThreadSafeImpl.java)
=================

* used to reduce the overhead of acquiring a lock by first testing the locking criterion (the "lock hint") 
  without actually acquiring the lock.

References
```
http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
http://www.aristeia.com/Papers/DDJ_Jul_Aug_2004_revised.pdf
```


