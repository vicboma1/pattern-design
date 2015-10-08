[Composite pattern](http://javapapers.com/design-patterns/composite-design-pattern/)
=================

* A system consists of subsystems or components. Components can further be divided into smaller components.
  Further smaller components can be divided into smaller elements. This is a part-whole hierarchy.

```
World {
        contextList = [ Level { name='Level1_1' }, Level{ name='Level1_2' } ],
        name='World-1'
      }
      
World {
        contextList = [ Level { name='Level2_1' }, Level{ name='Level2_2' }, Level{ name='Level2_3' } ],
        name='World-2'
      }
        
World {
        contextList = [ Level { name='Level3_1' } ],
        name='World-3'
      }
      
World { 
        contextList = [ Level { name='Level4_1' }, Level{ name='Level4_2' }, Level{ name='Level4_3' }, Level{ name='Level4_4' } ],
        name='World-4'
      }
```
