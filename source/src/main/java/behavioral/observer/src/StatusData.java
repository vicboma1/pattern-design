package behavioral.observer.src;

import behavioral.observer.api.Observer;

/**
 * Created by vicboma on 03/06/14.
 */
public class StatusData<E extends Observer> extends Observable<E> {
    public static <E extends Observer> StatusData<E> create() {
        return new StatusData<E>();
    }

    public void set(Integer attack, Integer health, String name) {
        notification(attack, health, name);
    }
}
