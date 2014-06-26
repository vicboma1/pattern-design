package structural.bridge.src.vehicle;

import structural.bridge.api.Engine;

/**
 * Created by vicboma on 26/06/14.
 */
public class Motoreta extends Vehicle {

    public Motoreta(Engine engine) {
        super(engine);
    }

    @Override
    public void speedingUp(Double combustion) {
        if (this.isStart()) {
            this.topCombustion -= combustion;
            this.engine.inject(topCombustion);
        }
    }

    @Override
    public void showStatus() {
        System.out.println("Motoreta{" + "isStart=" + this.isStart() + ", " + this.engine.toString() + "}");
    }
}
