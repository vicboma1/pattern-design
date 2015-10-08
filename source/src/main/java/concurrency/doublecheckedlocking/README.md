[Double-Checked Locking pattern](http://www.javaworld.com/article/2074979/java-concurrency/double-checked-locking--clever--but-broken.html)
=================

* Used to reduce the overhead of acquiring a lock by first testing the locking criterion (the "lock hint") 
  without actually acquiring the lock.

Examples
```
https://github.com/vicboma1/pattern-design/blob/master/src/creational/singletonthreadsafe
https://github.com/vicboma1/pattern-design/tree/master/src/creational/multitondoublecheckedlocking
```

References
```
http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
http://www.aristeia.com/Papers/DDJ_Jul_Aug_2004_revised.pdf
```


