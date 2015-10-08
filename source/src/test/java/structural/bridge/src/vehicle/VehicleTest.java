package structural.bridge.src.vehicle;

import org.junit.Before;
import org.junit.Test;
import structural.bridge.api.Engine;
import structural.bridge.src.motor.Diesel;
import structural.bridge.src.motor.Gasoline;
import structural.bridge.src.motor.Stroke;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class VehicleTest {

    private Vehicle vehicle;
    private Engine engine;

    @Before
    public void setUp() throws Exception {
        engine = Diesel.create(Stroke.FOUR);
        vehicle = new Porsche(engine);
    }

    @Test
    public void testSpeedingUp() throws Exception {
        Vehicle vehicleSpy = spy(vehicle);
        final double combustion = 15.0;
        vehicleSpy.onEngine();
        vehicleSpy.speedingUp(combustion);
        verify(vehicleSpy).speedingUp(combustion);
    }

    @Test
    public void testShowStatus() throws Exception {
        Vehicle vehicleSpy =  spy(vehicle);
        vehicleSpy.showStatus();
        verify(vehicleSpy).showStatus();
    }

    @Test
    public void testIsStart() throws Exception {
        vehicle.onEngine();
        assertTrue("fail start", vehicle.isStart());
    }

    @Test
    public void testOnEngine() throws Exception {
        Vehicle vehicleSpy = spy(vehicle);
        vehicleSpy.onEngine();
        verify(vehicleSpy).onEngine();
    }

    @Test
    public void testOffEngine() throws Exception {
        Vehicle vehicleSpy = spy(vehicle);
        vehicleSpy.offEngine();
        verify(vehicleSpy).offEngine();
    }

    @Test
    public void test() throws Exception {
        List<Vehicle> vehicleList = new ArrayList() {
            {
                add(new Porsche(Gasoline.create(Stroke.FOUR)));
                add(new Lamborghini(Gasoline.create(Stroke.TWO)));
                add(new Lamborghini(Diesel.create(Stroke.TWO)));
                add(new Motoreta(Gasoline.create(Stroke.NULL)));
                add(new Porsche(Diesel.create(Stroke.HYBRID)));
            }
        };

        final Double combustion = 15.0;
        IntStream stream = IntStream.range(0, 30);
        stream.sequential().forEach(x -> {
            final Vehicle vehicle = vehicleList.get(x % 4);
            vehicle.onEngine();
            vehicle.speedingUp(combustion);
            vehicle.showStatus();
        });

        stream = IntStream.range(0, 1);
        stream.sequential().forEach(x -> {
            final Vehicle vehicle = vehicleList.get(x);
            vehicle.offEngine();
        });

    }
}