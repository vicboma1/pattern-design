package behavioral.observer.src.model;

/**
 * Created by vicboma on 03/06/14.
 */
public class Properties {

    public static final int INIT_ATTACK = 5;
    public static final int INIT_HEALTH = 50;

    private String name;
    private Integer attack;
    private Integer health;

    public static Properties create(String name) {
        return new Properties(name);
    }

    Properties(String name) {
        this.name = name;
        this.attack = INIT_ATTACK;
        this.health = INIT_HEALTH;
    }

    public void set(Integer attack, Integer health) {
        sumAttack(attack);
        sumHealth(attack, health);
    }

    private void sumHealth(Integer attack, Integer health) {
        final int increment = this.health() + health;
        final int actual = increment - attack;
        this.health(actual);
    }

    private void sumAttack(Integer attack) {
        this.attack(attack);
    }

    private void attack(Integer attack) {
        this.attack = this.attack + attack;
    }

    private void health(Integer health) {
        this.health = health;
    }

    public String name() {
        return name;
    }

    public Integer attack() {
        return attack;
    }

    public Integer health() {
        return health;
    }
}
