package structural.bridge.src.vehicle;

import structural.bridge.api.Engine;

/**
 * Created by vicboma on 26/06/14.
 */
public class Porsche extends Vehicle {
    private Double speedSpoiler;

    public Porsche(Engine engine) {
        super(engine);
        factor = 0.35;
        speedSpoiler = 0.15;
    }

    @Override
    public void speedingUp(Double combustion) {
        if (this.isStart()) {
            this.topCombustion -= combustion * factor * speedSpoiler;
            this.engine.inject(topCombustion);
        }
    }

    @Override
    public void showStatus() {
        System.out.println("Porsche{" + "isStart=" + this.isStart() + ", " + this.engine.toString() + "}");
    }
}
