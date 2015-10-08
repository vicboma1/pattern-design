package structural.bridge.api;

/**
 * Created by vicboma on 25/06/14.
 */
public interface Engine {
    void start();
    void inject(Double combustion);

    void stop();

    Boolean isStart();
}
