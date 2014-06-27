package structural.frontcontroller.src;

/**
 * Created by vicboma on 27/06/14.
 */
public class MenuController {

    private Dispatcher dispatcher;
    private int selectItem;

    public static MenuController create(Dispatcher _dispatcher) {
        return new MenuController(_dispatcher);
    }

    MenuController(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
        this.selectItem = 0;
    }

    public void actual() {
        this.dispatcher.dispatch(this.selectItem);
    }

    public void next() {
        Integer actualIndex = fix(++this.selectItem);
        this.dispatcher.dispatch(actualIndex);
    }

    public void back() {
        Integer actualIndex = fix(--this.selectItem);
        this.dispatcher.dispatch(actualIndex);
    }

    private Integer fix(final int index) {
        final int endIndex = this.dispatcher.size() - 1;
        final int initIndex = 0;

        if (index < initIndex)
            this.selectItem = endIndex;
        else if (index > endIndex)
            this.selectItem = initIndex;

        return this.selectItem;
    }
}
