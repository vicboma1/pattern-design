package structural.bridge.src.vehicle;

import structural.bridge.api.Engine;

/**
 * Created by vicboma on 26/06/14.
 */
public abstract class Vehicle {
    protected Engine engine;
    protected Double topCombustion;
    protected Double factor;

    protected Vehicle(Engine engine) {
        this.engine = engine;
        this.topCombustion = 100.0;
    }

    abstract void speedingUp(Double combustion);

    abstract void showStatus();

    public Boolean isStart() {
        return this.engine.isStart() && this.topCombustion >= 0;
    }

    public void onEngine() {
        this.engine.start();
    }

    public void offEngine() {
        this.engine.stop();
    }


}
