package bowlinggame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GameTest {
    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void allRollsInTheGutter() {
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }

        assertEquals(game.getScore(), 0);
    }
}
