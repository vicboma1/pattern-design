package creational.prototype.src;

import creational.prototype.api.Projectile;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 10/06/14
 * Time: 13:29
 * To change this template use File | Settings | File Templates.
 */
public class Gun<B extends Projectile> {
    public static final int CHARGER_BULLETS = 10;
    private String name;
    private Boolean isActive;
    private List<B> bullet;
    private Integer charger;

    public Gun(String name, Boolean active, List<B> bullet, Integer charger) {
        this.name = name;
        this.isActive = active;
        this.bullet = bullet;
        this.charger = charger;
    }

    public Boolean shoot(Point2D.Double movement) {
        Boolean result = isActive();
        if (result) {
            final Consumer<B> action = e -> e.update(movement);

            bullet.stream()
                    .sequential()
                    .forEach(action);

            this.bullet.clear();
        }

        return result;
    }

    public String name() {
        return name;
    }

    public Boolean isActive() {
        Boolean result = true;
        if (availableBullets() <= 0)
            result = false;

        return result;
    }

    public void charger(Integer charger) {
        if (charger <= 0)
            return;

        this.charger = charger;
        this.isActive = true;
    }

    public Integer availableBullets() {
        final int result = this.bullet.size();
        return result;
    }
}
