[Family Factory pattern](http://www.javaworld.com/article/2074979/java-concurrency/double-checked-locking--clever--but-broken.html)
=================

* Allow us to write methods that create new objects without explicitly using the new operator. 
  This allows us to write methods that can instantiate different objects and that can be extended 
  to instantiate other newly-developed objects, all without modifying the method's code.
  
```
newWorkStealingPool java.util.concurrent.ForkJoinPool@5025a98f[Running, parallelism = 4, size = 0, active = 0, running = 0, steals = 0, tasks = 0, submissions = 0]
newWorkStealingPool java.util.concurrent.ForkJoinPool@49993335[Running, parallelism = 4, size = 0, active = 0, running = 0, steals = 0, tasks = 0, submissions = 0]
newWorkStealingPool java.util.concurrent.ForkJoinPool@20322d26[Running, parallelism = 4, size = 0, active = 0, running = 0, steals = 0, tasks = 0, submissions = 0]
newWorkStealingPool java.util.concurrent.ForkJoinPool@192b07fd[Running, parallelism = 4, size = 0, active = 0, running = 0, steals = 0, tasks = 0, submissions = 0]

newCachedThreadPool java.util.concurrent.ThreadPoolExecutor@704a52ec[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
newCachedThreadPool java.util.concurrent.ThreadPoolExecutor@6ee52dcd[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
newCachedThreadPool java.util.concurrent.ThreadPoolExecutor@4493d195[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
newCachedThreadPool java.util.concurrent.ThreadPoolExecutor@2781e022[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]

newCachedThreadPool java.util.concurrent.ThreadPoolExecutor@1877ab81[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
newCachedThreadPool java.util.concurrent.ThreadPoolExecutor@305fd85d[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
newCachedThreadPool java.util.concurrent.ThreadPoolExecutor@458c1321[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
newCachedThreadPool java.util.concurrent.ThreadPoolExecutor@11438d26[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]

newSingleThreadExecutor java.util.concurrent.Executors$FinalizableDelegatedExecutorService@ea1a8d5
newSingleThreadExecutor java.util.concurrent.Executors$FinalizableDelegatedExecutorService@1563da5
newSingleThreadExecutor java.util.concurrent.Executors$FinalizableDelegatedExecutorService@2bbf4b8b
newSingleThreadExecutor java.util.concurrent.Executors$FinalizableDelegatedExecutorService@30a3107a

newWorkStealingPool java.util.concurrent.ForkJoinPool@33c7e1bb[Running, parallelism = 4, size = 0, active = 0, running = 0, steals = 0, tasks = 0, submissions = 0]
newWorkStealingPool java.util.concurrent.ForkJoinPool@34c4973[Running, parallelism = 4, size = 0, active = 0, running = 0, steals = 0, tasks = 0, submissions = 0]
newWorkStealingPool java.util.concurrent.ForkJoinPool@52feb982[Running, parallelism = 4, size = 0, active = 0, running = 0, steals = 0, tasks = 0, submissions = 0]
newWorkStealingPool java.util.concurrent.ForkJoinPool@7a765367[Running, parallelism = 4, size = 0, active = 0, running = 0, steals = 0, tasks = 0, submissions = 0]

newFixedThreadPool java.util.concurrent.ThreadPoolExecutor@76b0bfab[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
newFixedThreadPool java.util.concurrent.ThreadPoolExecutor@17d677df[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
newFixedThreadPool java.util.concurrent.ThreadPoolExecutor@3043fe0e[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
newFixedThreadPool java.util.concurrent.ThreadPoolExecutor@480bdb19[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]

newSingleThreadExecutor java.util.concurrent.ThreadPoolExecutor@2f943d71[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
newSingleThreadExecutor java.util.concurrent.ThreadPoolExecutor@80503[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
newSingleThreadExecutor java.util.concurrent.ThreadPoolExecutor@4b553d26[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
newSingleThreadExecutor java.util.concurrent.ThreadPoolExecutor@69a3d1d[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]

newFixedThreadPool java.util.concurrent.ThreadPoolExecutor@2a556333[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
newFixedThreadPool java.util.concurrent.ThreadPoolExecutor@78e67e0a[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
newFixedThreadPool java.util.concurrent.ThreadPoolExecutor@7d70d1b1[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
newFixedThreadPool java.util.concurrent.ThreadPoolExecutor@2a742aa2[Running, pool size = 0, active threads = 0, queued tasks = 0, completed tasks = 0]
``