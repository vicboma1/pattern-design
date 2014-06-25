package structural.bridge.api;

/**
 * Created by vicboma on 25/06/14.
 */
public interface Motor {
    Boolean start();

    void inject(Double combustion);

    Boolean stop();
}
