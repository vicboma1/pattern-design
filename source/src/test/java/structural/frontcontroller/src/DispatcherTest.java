package structural.frontcontroller.src;

import org.junit.Before;
import org.junit.Test;
import structural.frontcontroller.src.view.Configuration;
import structural.frontcontroller.src.view.Exit;
import structural.frontcontroller.src.view.LoadGame;
import structural.frontcontroller.src.view.PlayGame;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class DispatcherTest {

    private Dispatcher dispatcher;

    @Before
    public void setUp() throws Exception {
        dispatcher = Dispatcher.create();
    }

    @Test
    public void testRegister() throws Exception {
        final int index = 0;
        final Exit command = new Exit();
        Dispatcher dispatcherSpy = spy(dispatcher);
        dispatcherSpy.register(index, command);
        verify(dispatcherSpy).register(index, command);
    }

    @Test
    public void testDispatch() throws Exception {
        final int index = 0;
        Dispatcher dispatcherSpy = spy(dispatcher);
        dispatcherSpy.register(index, new PlayGame());
        dispatcherSpy.dispatch(index);
        verify(dispatcherSpy).dispatch(index);
    }

    @Test
    public void testSize() throws Exception {
        Integer expected = 4;
        registerDispatch();
        assertEquals("fail size", expected, this.dispatcher.size());
    }

    private void registerDispatch() {
        dispatcher
                .register(0, new PlayGame())
                .register(1, new Configuration())
                .register(2, new LoadGame())
                .register(3, new Exit());
    }
}