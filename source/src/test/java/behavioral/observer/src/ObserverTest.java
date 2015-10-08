package behavioral.observer.src;

import behavioral.observer.api.Observer;
import behavioral.observer.api.View;
import behavioral.observer.src.model.Properties;
import behavioral.observer.src.model.enemy.Enemy;
import behavioral.observer.src.model.player.Player;
import org.junit.Test;


public class ObserverTest {

	@Test
	public void test() {
		final StatusData<Observer> statusData = StatusData.create();

        final View viewPlayer1 = DisplayElement.create();
        final Properties properties1 = Properties.create("Joe");
        final Player player1 = Player.create(properties1, statusData, viewPlayer1);

        final View viewPlayer2 = DisplayElement.create();
        final Properties player2Properties = Properties.create("Mac");
        final Player player2 = Player.create(player2Properties, statusData,viewPlayer2);

        final View viewEnemy1 = DisplayElement.create();
        final Properties enemy1Properties = Properties.create("Cannibal");
        final Enemy enemy1 = Enemy.create(enemy1Properties, statusData,viewEnemy1);

        final View viewEnemy2 = DisplayElement.create();
        final Properties enemy2Properties = Properties.create("Depredator");
        final Enemy enemy2 = Enemy.create(enemy2Properties, statusData,viewEnemy2);

        gaming(player1, player2, enemy1, enemy2);

    }


	private static void gaming(final Player player1, final Player player2,
			final Enemy enemy1, final Enemy enemy2) {
		player1.set(10, 0);
        player2.set(0, 50);
        enemy1.set(15, 0);
        player1.set(10, 5);
        enemy2.set(30, 0);
        enemy1.set(15, 0);
        player2.set(20, 0);
        enemy2.set(5, 0);
        enemy1.set(15, 0);
        player2.set(20, 10);
        enemy1.set(5, 0);
        player1.set(25, 0);
        enemy2.set(5, 0);
        enemy1.set(5, 0);
        player2.set(20, 0);
        enemy2.set(5, 0);
        player1.set(10,20);
	}
}
