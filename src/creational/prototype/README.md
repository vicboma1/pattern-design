[Prototype pattern](http://en.wikipedia.org/wiki/Prototype_pattern)
=================

*  It is used when the type of objects to create is determined by a prototypical instance,
   which is cloned to produce new objects.

```
Bullet bullet = new BulletImpl(".357", 50, new Point2D.Double(0.0, 0.0)); creational.prototype.src.BulletImpl@6f50d55c
 
bullet.clone() creational.prototype.src.BulletImpl@6c835217
bullet.clone() creational.prototype.src.BulletImpl@4584304
bullet.clone() creational.prototype.src.BulletImpl@51888019
bullet.clone() creational.prototype.src.BulletImpl@6f50d55c
bullet.clone() creational.prototype.src.BulletImpl@19b5214b
bullet.clone() creational.prototype.src.BulletImpl@5fb3111a
bullet.clone() creational.prototype.src.BulletImpl@4aaecabd
bullet.clone() creational.prototype.src.BulletImpl@23bd0c81
bullet.clone() creational.prototype.src.BulletImpl@1332dec4
bullet.clone() creational.prototype.src.BulletImpl@544e3679
bullet.clone() creational.prototype.src.BulletImpl@6889f56f
bullet.clone() creational.prototype.src.BulletImpl@231b35fb
bullet.clone() creational.prototype.src.BulletImpl@26da1ba2
bullet.clone() creational.prototype.src.BulletImpl@3820cfe
bullet.clone() creational.prototype.src.BulletImpl@2407a36c
...

```