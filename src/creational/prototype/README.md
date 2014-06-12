[Prototype pattern](http://en.wikipedia.org/wiki/Prototype_pattern)
=================

*  It is used when the type of objects to create is determined by a prototypical instance,
   which is cloned to produce new objects.

```
Projectile projectile = new BulletImpl(".357", 50, new Point2D.Double(0.0, 0.0)); creational.prototype.src.model.BulletImpl@6f50d55c
 
bullet.clone() creational.prototype.src.model.ProjectileImpl@29a60c27
bullet.clone() creational.prototype.src.model.ProjectileImpl@1849db1a
bullet.clone() creational.prototype.src.model.ProjectileImpl@69c79f09
bullet.clone() creational.prototype.src.model.ProjectileImpl@1ca25c47
bullet.clone() creational.prototype.src.model.ProjectileImpl@5fcacc0
bullet.clone() creational.prototype.src.model.ProjectileImpl@533b266e
bullet.clone() creational.prototype.src.model.ProjectileImpl@6d1d4d7
bullet.clone() creational.prototype.src.model.ProjectileImpl@89ff02e
bullet.clone() creational.prototype.src.model.ProjectileImpl@6865c751
bullet.clone() creational.prototype.src.model.ProjectileImpl@62679465
bullet.clone() creational.prototype.src.model.ProjectileImpl@6a988392
bullet.clone() creational.prototype.src.model.ProjectileImpl@1d71006f
bullet.clone() creational.prototype.src.model.ProjectileImpl@5b6813df
bullet.clone() creational.prototype.src.model.ProjectileImpl@5f2606b
bullet.clone() creational.prototype.src.model.ProjectileImpl@2b58f754
bullet.clone() creational.prototype.src.model.ProjectileImpl@3ebff828
bullet.clone() creational.prototype.src.model.ProjectileImpl@2552f2cb
bullet.clone() creational.prototype.src.model.ProjectileImpl@33352f32
bullet.clone() creational.prototype.src.model.ProjectileImpl@5f3b9c57
bullet.clone() creational.prototype.src.model.ProjectileImpl@1e044120

...

With a factory projectile:
...
Projectile Bullet creational.prototype.src.model.BulletImpl@10c8f62
Projectile Clone Bullet creational.prototype.src.model.ProjectileImpl@674c583e
Projectile Bullet creational.prototype.src.model.BulletImpl@10c8f62
Projectile Clone Bullet creational.prototype.src.model.ProjectileImpl@25f7391e
Projectile Bullet creational.prototype.src.model.BulletImpl@10c8f62
Projectile Clone Bullet creational.prototype.src.model.ProjectileImpl@3f23a3a0
Projectile Bullet creational.prototype.src.model.BulletImpl@10c8f62
Projectile Clone Bullet creational.prototype.src.model.ProjectileImpl@5ab14cb9

Projectile Missile creational.prototype.src.model.MissileImpl@5fb97279
Projectile Clone Missile creational.prototype.src.model.ProjectileImpl@439a8f59
Projectile Missile creational.prototype.src.model.MissileImpl@5fb97279
Projectile Clone Missile creational.prototype.src.model.ProjectileImpl@61861a29
Projectile Missile creational.prototype.src.model.MissileImpl@5fb97279
Projectile Clone Missile creational.prototype.src.model.ProjectileImpl@31024624
Projectile Missile creational.prototype.src.model.MissileImpl@5fb97279
Projectile Clone Missile creational.prototype.src.model.ProjectileImpl@25bcd0c7
...

```