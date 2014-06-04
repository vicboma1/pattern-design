package behavioral.observer.src;

import behavioral.observer.api.View;

public class DisplayElement implements View {

    public static View create() {
        return new DisplayElement();
    }

    @Override
    public Boolean display(Boolean isDead, Integer attack, Integer health, String name, String nameNotify) {
        System.out.println("Notify [" + nameNotify + "] -> New status for " + name + " | Total Attacks: " + attack + " | Actual Health: " + health + " | is Dead ? " + isDead);
        return true;
    }
}
