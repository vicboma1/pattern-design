package structural.frontcontroller.src;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.verification.api.VerificationData;
import org.mockito.invocation.Invocation;
import org.mockito.verification.VerificationMode;
import structural.frontcontroller.src.view.Configuration;
import structural.frontcontroller.src.view.Exit;
import structural.frontcontroller.src.view.LoadGame;
import structural.frontcontroller.src.view.PlayGame;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class MenuControllerTest {

    private Dispatcher dispatcher;
    private MenuController menuController;

    @Before
    public void setUp() throws Exception {
        registerDispatch();
        menuController = MenuController.create(this.dispatcher);
    }

    @Test
    public void testActual() throws Exception {
        MenuController menuControllerSpy = spy(menuController);
        menuControllerSpy.actual();
        verify(menuControllerSpy).actual();
    }

    @Test
    public void testNext() throws Exception {
        MenuController menuControllerSpy = spy(menuController);
        menuControllerSpy.next();
        verify(menuControllerSpy).next();
    }

    @Test
    public void testBack() throws Exception {
        MenuController menuControllerSpy = spy(menuController);
        menuControllerSpy.back();
        verify(menuControllerSpy).back();
    }

    @Test
    public void test() throws Exception {
        final int expectedFinal = 16;
        MenuController menuControllerSpy = spy(menuController);
        menuControllerSpy.actual();
        menuControllerSpy.back();
        menuControllerSpy.back();
        menuControllerSpy.back();
        menuControllerSpy.back();
        menuControllerSpy.back();
        menuControllerSpy.next();
        menuControllerSpy.next();
        menuControllerSpy.next();
        menuControllerSpy.next();
        menuControllerSpy.next();
        menuControllerSpy.next();
        menuControllerSpy.back();
        menuControllerSpy.next();
        menuControllerSpy.next();
        menuControllerSpy.back();
        verify(menuControllerSpy, new VerificationMode() {
            @Override
            public void verify(VerificationData data) {
                final List<Invocation> allInvocations = data.getAllInvocations();
                assertEquals("fail invocations", expectedFinal, allInvocations.size());
            }
        }).back();

        verify(menuControllerSpy, new VerificationMode() {
            @Override
            public void verify(VerificationData data) {
                final List<Invocation> allInvocations = data.getAllInvocations();
                assertEquals("fail invocations", expectedFinal, allInvocations.size());
            }
        }).next();

        verify(menuControllerSpy).actual();
    }

    private void registerDispatch() {
        this.dispatcher = Dispatcher.create()
                .register(0, new PlayGame())
                .register(1, new Configuration())
                .register(2, new LoadGame())
                .register(3, new Exit());
    }
}