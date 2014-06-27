package structural.frontcontroller.src.view;

import structural.frontcontroller.api.Commander;

/**
 * Created by vicboma on 27/06/14.
 */
public class Exit implements Commander {
    @Override
    public void execute() {
        System.out.println("Exit");
    }
}
