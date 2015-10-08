package structural.bridge.src.vehicle;

import structural.bridge.api.Engine;

/**
 * Created by vicboma on 26/06/14.
 */
public class Lamborghini extends Vehicle {

    public Lamborghini(Engine engine) {
        super(engine);
        factor = 0.15;
    }

    @Override
    public void speedingUp(Double combustion) {
        if (this.isStart())
            this.topCombustion -= combustion * factor;
        this.engine.inject(topCombustion);
    }

    @Override
    public void showStatus() {
        System.out.println("Lamborghini{" + "isStart=" + this.isStart() + ", " + this.engine.toString() + "}");
    }
}
