package structural.bridge.src.motor;

import structural.bridge.api.Engine;

/**
 * Created by vicboma on 26/06/14.
 */
public class Diesel implements Engine {
    private Boolean isRun;
    private Stroke stroke;

    public static Diesel create(Stroke stroke) {
        return new Diesel(stroke);
    }

    Diesel(Stroke stroke) {
        this.stroke = stroke;
        this.isRun = false;
    }

    @Override
    public void start() {
        isRun = true;
    }

    @Override
    public void inject(Double combustion) {
        if (isRun)
            System.out.println("Inject combustion Disel " + combustion);
    }

    @Override
    public void stop() {
        isRun = false;
    }

    @Override
    public Boolean isStart() {
        return this.isRun;
    }

    @Override
    public String toString() {
        return "Diesel{" + "isRun=" + isRun + ", stroke=" + stroke + '}';
    }
}
